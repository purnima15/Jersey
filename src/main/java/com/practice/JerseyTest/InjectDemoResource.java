
package com.practice.JerseyTest;

import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.CookieParam;
import javax.ws.rs.HeaderParam;
import javax.ws.rs.GET;
import javax.ws.rs.MatrixParam;
import javax.ws.rs.Produces;
import javax.ws.rs.Consumes;
import javax.ws.rs.Path;

@Path("/injectDemo")
public class InjectDemoResource
{
   /* @GET
    @Consumes({ "text/plain" })
    @Produces({ "text/plain" })
    @Path("/matrix")
    public String getMatrixParam(@MatrixParam("param") String matrixparam) {
        return "Matrix Param:" + matrixparam;
    }
    
    @GET
    @Path("/header")
    public String getheaderParam(@HeaderParam("param") final String headerParam) {
        return "Header Param:" + headerParam;
    }
   */ 
    @GET
    @Path("cookie")
    public String getcookieParam(@CookieParam("name") final String cookieParam) {
        return "Cookie Param:" + cookieParam;
    }
    
    @GET
    @Path("context")
    public String getcontextParam(@Context final UriInfo uriInfo, @Context final HttpHeaders headers) {
        final String uripath = uriInfo.getAbsolutePath().toString();
        final String cookies = headers.getCookies().toString();
        return "URI Info:" + uripath + " Cookies " + cookies;
    }
}