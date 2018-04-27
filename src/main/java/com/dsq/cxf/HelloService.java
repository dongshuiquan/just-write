package com.dsq.cxf;

import javax.jws.WebService;

/**
 * Created by DELL on 2018/4/1.
 */

@WebService
public interface HelloService {

    String say(String name);

}
