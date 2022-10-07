package kz.iitu.cfaslib.feign;

import kz.iitu.cfaslib.dto.UserDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(value = "user-management", path = "/user-api")
@Service
public interface UserFeign {
    @GetMapping(value = "/username/{username}")
    ResponseEntity<UserDto> byUsername(@PathVariable String username);
}
