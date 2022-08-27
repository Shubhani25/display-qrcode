package com.tgt.upcurve.displayqrcode.service;
import com.tgt.upcurve.displayqrcode.model.Image;
import com.tgt.upcurve.displayqrcode.model.ImageRequest;
import com.tgt.upcurve.displayqrcode.repository.ImageRepository;
import org.springframework.stereotype.Service;

@Service
public class DisplayQRCodeService {
    private final ImageRepository imageRepository;

    public DisplayQRCodeService(ImageRepository imageRepository)
    {
        this.imageRepository = imageRepository;
    }

    public byte[] getQRCode(){
        String content = "http://localhost:8080/aggregator_api/v1/guest_arrival/order_id/10/customer_id/10";
        ImageRequest imageRequest = new ImageRequest();
        imageRequest.setContent(content);
        Image image = imageRepository.generateImageByContent(imageRequest);
        return image.getImageCode();
    }
}
