package kz.iitu.cfaslib.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(value = "auth-service", path = "${feign.path.auth-service}")
@Service
public interface AuthFeign {

    @PostMapping(value = "/validateToken")
    boolean validateToken(@RequestParam String token);

}
