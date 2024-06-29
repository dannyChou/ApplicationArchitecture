class AlbumService...

    String play(String id) throws RemoteException;
    String getAlbumXml(String id) throws RemoteException;
    AlbumDTO getAlbum(String id) throws RemoteException;
    void createAlbum(String id, String xml) throws RemoteException;
    void createAlbum(String id, AlbumDTO dto) throws RemoteException;
    void updateAlbum(String id, String xml) throws RemoteException;
    void updateAlbum(String id, AlbumDTO dto) throws RemoteException;
    void addArtistNamed(String id, String name) throws RemoteException;
    void addArtist(String id, String xml) throws RemoteException;
    void addArtist(String id, ArtistDTO dto) throws RemoteException;
    ArtistDTO getArtist(String id) throws RemoteException;