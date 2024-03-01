package dog.service;


import dog.entity.Gallery;

import java.util.List;

public interface GalleryService {
    public static final int COUNT_PER_PAGE = 10;

//    List<Gallery> getGalleryList(int page, String field, String query);
    List<Gallery> getGalleryList(int page, String field);

    Gallery getGallery(int galleryId);

//    int getGalleryCount(String field, String query);
    int getGalleryCount(String field);

    void insertGallery(Gallery gallery);

    void updateGallery(Gallery gallery);

    void deleteGallery(int galleryId);

    void increaseLiked(int galleryId, String uId);

}
