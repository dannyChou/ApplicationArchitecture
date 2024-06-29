<UL>
<%
    for (Iterator it = helper.getAlbums().iterator(); it.hasNext();) {
        Album album = (Album) it.next();%>
    <LI><%=album.getTitle()%></LI>
<% } %>
</UL>