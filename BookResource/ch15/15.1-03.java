class XmlTester...

    private AlbumDTO kob;
    private AlbumDTO newkob;
    private AlbumServiceBean facade = new AlbumServiceBean();
    protected void setUp() throws Exception {
        facade.initializeForTesting();
        kob = facade.getAlbum("kob");
        Writer buffer = new StringWriter();
        kob.toXmlString(buffer);
        newkob = AlbumDTO.readXmlString(new StringReader(buffer.toString()));
    }
    public void testArtist() {
        assertEquals(kob.getArtist(), newkob.getArtist());
    }