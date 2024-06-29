class AlbumAssembler...

    public void createAlbum(String id, AlbumDTO source) {
        Artist artist = Registry.findArtistNamed(source.getArtist());
        if (artist == null)
            throw new RuntimeException("No artist named " + source.getArtist());
        Album album = new Album(source.getTitle(), artist);
        createTracks(source.getTracks(), album);
        Registry.addAlbum(id, album);
    }
    private void createTracks(TrackDTO[] tracks, Album album) {
        for (int i = 0; i < tracks.length; i++) {
            Track newTrack = new Track(tracks[i].getTitle());
            album.addTrack(newTrack);
            createPerformers(newTrack, tracks[i].getPerformers());
        }
    }
    private void createPerformers(Track newTrack, String[] performerArray) {
        for (int i = 0; i < performerArray.length; i++) {
            Artist performer = Registry.findArtistNamed(performerArray[i]);
            if (performer == null)
                throw new RuntimeException("No artist named " + performerArray[i]);
            newTrack.addPerformer(performer);
        }
    }