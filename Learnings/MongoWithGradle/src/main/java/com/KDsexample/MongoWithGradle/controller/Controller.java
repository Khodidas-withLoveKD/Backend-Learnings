package com.KDsexample.MongoWithGradle.controller;

import org.apache.tomcat.util.codec.binary.Base64;
import org.springframework.web.bind.annotation.*;

import java.io.*;
import java.net.URL;
import java.net.URLConnection;
import java.nio.ByteBuffer;
import java.nio.channels.Channels;
import java.nio.channels.ReadableByteChannel;
import java.nio.charset.StandardCharsets;
import java.util.stream.Collectors;

@RestController
@RequestMapping("test/")
public class Controller {

    @PostMapping("email/download")
    public void sendEmail () throws IOException {
        URL url = new URL("https://esign-storage-dev.s3.ap-south-1.amazonaws.com/2/e9c1fba1-e98f-4e61-9c39-01a28c79e9a9?X-Amz-Algorithm=AWS4-HMAC-SHA256&X-Amz-Date=20210505T071402Z&X-Amz-SignedHeaders=host&X-Amz-Expires=604800&X-Amz-Credential=AKIAU7EBQ25OKE22QYMJ%2F20210505%2Fap-south-1%2Fs3%2Faws4_request&X-Amz-Signature=d2f2fd11c3fe067f883aec66818d3b3c13c057a7a2d357c96cb1446faaa170ec");
        ReadableByteChannel readableByteChannel = Channels.newChannel(url.openStream());
        System.out.println("readableByteChannel = " + readableByteChannel);
//        String str = getBA(url);
        ByteBuffer byteBuffer = getAsByteArray(url);
        String str = convertBBToStr(byteBuffer);
//        byte[] byteArray = str.getBytes(StandardCharsets.UTF_8);
//        System.out.println("byteArray = " + byteArray);
//        for (byte bt: byteArray) {
//            System.out.println(bt);
//        }
        if (str.equals(convertBackToString(byteBuffer.array()))) {
            System.out.println("====== TRUE =======");
        } else {
            System.out.println("====== FALSE ========");
        }
    }

    static String getBA(URL url) {
        try (InputStream in = url.openStream())
        {
            BufferedReader reader = new BufferedReader(new InputStreamReader(in));
            return reader.lines().collect(Collectors.joining(System.lineSeparator()));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "Yo";
    }

    static String convertBackToString(byte [] byteArray) {
        String attachmentString =
                new String(Base64.encodeBase64(byteArray), StandardCharsets.US_ASCII);
        System.out.println("attachmentString ===========================\n" + attachmentString);
        return attachmentString;
    }

    public static ByteBuffer getAsByteArray(URL url) throws IOException {
        URLConnection connection = url.openConnection();
        // Since you get a URLConnection, use it to get the InputStream
        InputStream in = connection.getInputStream();
        // Now that the InputStream is open, get the content length
        int contentLength = connection.getContentLength();

        // To avoid having to resize the array over and over and over as
        // bytes are written to the array, provide an accurate estimate of
        // the ultimate size of the byte array
        ByteArrayOutputStream tmpOut;
        if (contentLength != -1) {
            tmpOut = new ByteArrayOutputStream(contentLength);
        } else {
            tmpOut = new ByteArrayOutputStream(16384); // Pick some appropriate size
        }

        byte[] buf = new byte[512];
        while (true) {
            int len = in.read(buf);
            if (len == -1) {
                break;
            }
            tmpOut.write(buf, 0, len);
        }
        in.close();
        tmpOut.close(); // No effect, but good to do anyway to keep the metaphor alive

        byte[] array = tmpOut.toByteArray();

        //Lines below used to test if file is corrupt
        //FileOutputStream fos = new FileOutputStream("C:\\abc.pdf");
        //fos.write(array);
        //fos.close();

        return ByteBuffer.wrap(array);
    }

    static String convertBBToStr(ByteBuffer byteBuffer) {
        byteBuffer.flip(); // flip the buffer for reading
        byte[] bytes = new byte[byteBuffer.remaining()]; // create a byte array the length of the number of bytes written to the buffer
        byteBuffer.get(bytes); // read the bytes that were written
        return new String(bytes);
    }
}
