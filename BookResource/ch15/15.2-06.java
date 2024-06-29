class AlbumDTO...

    Element toXmlElement() {
        Element root = new Element("album");
        root.setAttribute("title", title);
        root.setAttribute("artist", artist);
        for (int i = 0; i < tracks.length; i++)
            root.addContent(tracks[i].toXmlElement());
        return root;
    }
    static AlbumDTO readXml(Element source) {
        AlbumDTO result = new AlbumDTO();
        result.setTitle(source.getAttributeValue("title"));
        result.setArtist(source.getAttributeValue("artist"));
        List trackList = new ArrayList();
        Iterator it = source.getChildren("track").iterator();
        while (it.hasNext())
            trackList.add(TrackDTO.readXml((Element) it.next()));
        result.setTracks((TrackDTO[]) trackList.toArray(new TrackDTO[0]));
        return result;
    }

class TrackDTO...

    Element toXmlElement() {
        Element result = new Element("track");
        result.setAttribute("title", title);
        for (int i = 0; i < performers.length; i++) {
            Element performerElement = new Element("performer");
            performerElement.setAttribute("name", performers[i]);
            result.addContent(performerElement);
        }
        return result;
    }
    static TrackDTO readXml(Element arg) {
        TrackDTO result = new TrackDTO();
        result.setTitle(arg.getAttributeValue("title"));
        Iterator it = arg.getChildren("performer").iterator();
        List buffer = new ArrayList();
        while (it.hasNext()) {
            Element eachElement = (Element) it.next();
            buffer.add(eachElement.getAttributeValue("name"));
        }
        result.setPerformers((String[]) buffer.toArray(new String[0]));
        return result;
    }