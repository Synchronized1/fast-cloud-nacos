package fast.cloud.nacos.example.web.controller;

import fast.cloud.nacos.common.model.exception.BadRequestException;
import fast.cloud.nacos.common.model.response.ApiResponse;
import fast.cloud.nacos.example.web.bean.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.Size;

@RequestMapping("exception")
@Validated
@Slf4j
public class ExceptionDemoController {

    @GetMapping("demoA")
    public ApiResponse<String> demoA() {
        log.info("{}测试日志", "log");
        throw new BadRequestException("报错了。。。。");
    }

    @GetMapping("demoB")
    public ApiResponse<String> demoB() {
        throw new BadRequestException("报错了。。。。");
    }

    @GetMapping("/validate1")
    @ResponseBody
    public String validate1(
            @Size(min = 1, max = 10, message = "姓名长度必须为1到10") @RequestParam("name") String name) {
        return "validate1 测试";
    }

    /**
     * http://localhost:8888/exception/validate2?lang=en_US
     * http://localhost:8888/exception/validate2?lang=zh_CN
     *
     * @param user
     * @return
     */
    @PostMapping("/validate2")
    @ResponseBody
    public String validate2(@Valid
                            @RequestBody User user) {
        return "validate1";
    }
}
