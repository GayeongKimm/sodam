package hackers.ground.sodam.domain.thing.service;

import hackers.ground.sodam.domain.thing.entity.ThingEntity;
import hackers.ground.sodam.domain.thing.presentation.dto.req.ThingReq;
import hackers.ground.sodam.domain.thing.presentation.dto.res.ThingRes;
import hackers.ground.sodam.domain.thing.repository.ThingRepository;
import hackers.ground.sodam.domain.user.entity.SellerEntity;
import hackers.ground.sodam.domain.user.entity.UserEntity;
import hackers.ground.sodam.domain.user.repository.SellerRepository;
import hackers.ground.sodam.global.infra.security.GetCurrentMember;
import hackers.ground.sodam.global.page.PageRequest;
import hackers.ground.sodam.global.response.Response;
import hackers.ground.sodam.global.response.ResponseData;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ThingService {
    private final ThingRepository thingRepository;
    private final GetCurrentMember getCurrentMember;
    private final SellerRepository sellerRepository;

    public Response add(ThingReq thingReq){

        UserEntity userEntity = getCurrentMember.current();
        SellerEntity sellerEntity = sellerRepository.findByUserEntity(userEntity);

        thingRepository.save(ThingEntity
                .builder()
                        .arriveAt(thingReq.arriveAt())
                        .Category(thingReq.Category())
                        .min(thingReq.min())
                        .name(thingReq.name())
                        .possible(thingReq.possible())
                        .wantMoney(thingReq.wantMoney())
                        .sellerEntity(sellerEntity)
                .build());

        return Response.of(HttpStatus.OK, "성공");
    }

    public ResponseData<List<ThingRes>> load(PageRequest pageRequest){
        List<ThingEntity> thingEntityList = thingRepository.findAll();


        List<ThingRes> thingRes = thingEntityList.stream()
                .map((ThingEntity thingEntity) -> ThingRes.of(thingEntity, thingEntity.getSellerEntity()))
                .skip((pageRequest.page() -1) * pageRequest.size())
                .limit(pageRequest.size())
                .toList();


        return ResponseData.of(HttpStatus.OK, "성공", thingRes);
    }

}
