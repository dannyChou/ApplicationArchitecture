class AlbumAssembler...

    public void updateAlbum(String id, AlbumDTO source) {
        Album current = Registry.findAlbum(id);
        if (current == null)
            throw new RuntimeException("Album does not exist: " + source.getTitle());
        if (source.getTitle() != current.getTitle()) current.setTitle(source.getTitle());
        if (source.getArtist() != current.getArtist().getName()) {
            Artist artist = Registry.findArtistNamed(source.getArtist());
            if (artist == null)
                throw new RuntimeException("No artist named " + source.getArtist());
            current.setArtist(artist);
        }
        updateTracks(source, current);
    }
    private void updateTracks(AlbumDTO source, Album current) {
        for (int i = 0; i < source.getTracks().length; i++) {
            current.getTrack(i).setTitle(source.getTrackDTO(i).getTitle());
            current.getTrack(i).clearPerformers();
            createPerformers(current.getTrack(i), source.getTrackDTO(i).getPerformers());
        }
    }