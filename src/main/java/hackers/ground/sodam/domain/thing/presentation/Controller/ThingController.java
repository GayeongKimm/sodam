package hackers.ground.sodam.domain.thing.presentation.Controller;

import hackers.ground.sodam.domain.thing.presentation.dto.req.ThingReq;
import hackers.ground.sodam.domain.thing.presentation.dto.res.ThingRes;
import hackers.ground.sodam.domain.thing.repository.ThingRepository;
import hackers.ground.sodam.domain.thing.service.ThingService;
import hackers.ground.sodam.global.page.PageRequest;
import hackers.ground.sodam.global.response.Response;
import hackers.ground.sodam.global.response.ResponseData;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Tag(name = "Thing", description = "Thing Api")
@RestController
@RequestMapping(value = "/thing")
@RequiredArgsConstructor
public class ThingController {

    private final ThingRepository thingRepository;
    private final ThingService thingService;

    @PostMapping
    public Response add(
            @RequestBody ThingReq thingReq){
        return thingService.add(thingReq);
    }

    @GetMapping
    public ResponseData<List<ThingRes>> load(
            @ModelAttribute PageRequest pageRequest){
        return thingService.load(pageRequest);
    }
}
