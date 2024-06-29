class AlbumAssembler...

    public AlbumDTO writeDTO(Album subject) {
        AlbumDTO result = new AlbumDTO();
        result.setTitle(subject.getTitle());
        result.setArtist(subject.getArtist().getName());
        writeTracks(result, subject);
        return result;
    }
    private void writeTracks(AlbumDTO result, Album subject) {
        List newTracks = new ArrayList();
        Iterator it = subject.getTracks().iterator();
        while (it.hasNext()) {
            TrackDTO newDTO = new TrackDTO();
            Track thisTrack = (Track) it.next();
            newDTO.setTitle(thisTrack.getTitle());
            writePerformers(newDTO, thisTrack);
            newTracks.add(newDTO);
        }
        result.setTracks((TrackDTO[]) newTracks.toArray(new TrackDTO[0]));
    }
    private void writePerformers(TrackDTO dto, Track subject) {
        List result = new ArrayList();
        Iterator it = subject.getPerformers().iterator();
        while (it.hasNext()) {
            Artist each = (Artist) it.next();
            result.add(each.getName());
        }
        dto.setPerformers((String[]) result.toArray(new String[0]));
    }