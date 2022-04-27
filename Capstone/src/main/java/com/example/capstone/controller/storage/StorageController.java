package com.example.capstone.controller.storage;

import com.example.capstone.domain.Member.Member;
import com.example.capstone.domain.storage.*;
import com.example.capstone.dto.storage.*;
import com.example.capstone.repository.Member.MemberRepository;
import com.example.capstone.repository.Storage.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class StorageController {

    @Autowired
    private StorageRepository storageRepository;

    @Autowired
    private StorageManagerRepository storageManagerRepository;

    @Autowired
    private StorageBoxRepository storageBoxRepository;

    @Autowired
    private MemberRepository memberRepository;

    @Autowired
    private OrderListRepository orderListRepository;

    @Autowired
    private UseStorageBoxRepository useStorageBoxRepository;

    @PostMapping("/postStorage")
    public Result postStorage(@RequestBody Storage storage) {
        Optional<Storage> findStrg = storageRepository.findByStorageName(storage.getStorageName());

        if (!findStrg.isPresent()) {
            storageRepository.save(storage);
            return new Result("ok");
        } else {
            return new Result("no");
        }

    }

    //    보관함 만들기
    @PostMapping("/postBox")
    public Result postBox(@RequestBody Box box){
        Optional<Storage> findStorage = storageRepository.findByStorageName(box.getStorageName());
        Storage strg = findStorage.get();

        String storageBoxName;
        String storageBoxType;
        String storageBoxState;

        for (int i = 0; i < box.getSmall(); i++) {
            storageBoxName = "S"+(i+1);
            storageBoxType = "0";
            storageBoxState = "0";
            StorageBox storageBoxSmall = new StorageBox(strg,storageBoxName,storageBoxType,storageBoxState);
            storageBoxRepository.save(storageBoxSmall);

            storageBoxName = "0";
            storageBoxType = "0";
            storageBoxState = "0";
        }
        for (int i = 0; i < box.getMedium(); i++) {
            storageBoxName = "M"+(i+1);
            storageBoxType = "0";
            storageBoxState = "0";
            StorageBox storageBoxSmall = new StorageBox(strg,storageBoxName,storageBoxType,storageBoxState);
            storageBoxRepository.save(storageBoxSmall);

            storageBoxName = "0";
            storageBoxType = "0";
            storageBoxState = "0";
        }
        for (int i = 0; i < box.getLarge(); i++) {
            storageBoxName = "L"+(i+1);
            storageBoxType = "0";
            storageBoxState = "0";
            StorageBox storageBoxSmall = new StorageBox(strg,storageBoxName,storageBoxType,storageBoxState);
            storageBoxRepository.save(storageBoxSmall);

            storageBoxName = "0";
            storageBoxType = "0";
            storageBoxState = "0";
        }

        return new Result("ok");
    }

    //   보관소 매니저 생성
    @PostMapping("/postManager")
    public Result postManager(@RequestBody Manager manager) {
        Optional<Storage> storage = storageRepository.findById(manager.getStorage());
        List<Member> member = memberRepository.findByMID(manager.getMember());
        StorageManager storageManager = new StorageManager(member.get(0),storage.get());
        storageManagerRepository.save(storageManager);

        return new Result("ok");
    }

    //   보관소 매니저 체크
    @GetMapping("/checkManager/{memberId}")
    public Result checkManager(@PathVariable String memberId) throws NoSuchElementException {
        try {
            List<Member> member = memberRepository.findByMID(memberId);
            System.out.println(member.get(0).getMID());
            Optional<StorageManager> storageManager = storageManagerRepository.findByMCode(member.get(0));

            if (storageManager.isPresent()) {
                // 중복
                return new Result("overlap");

            }else{
                // 가능
                return new Result("ok");
            }
        }catch (NoSuchElementException n){
            System.out.println(n);
            return new Result("no");
        }
    }

    //    보관소 리스트
    @GetMapping("/getStorage")
    public List<Storage> getStorages() {
        List<Storage> storageList = storageRepository.findAll();
        return storageList;
    }

    //    보관소 상세보기
    @GetMapping("/storageView/{storageCode}")
    public List<StorageBox> getStorageDetail(@PathVariable(value = "storageCode") Long storageCode){
        Optional<Storage> storage = storageRepository.findById(storageCode);
        List<StorageBox> boxList = storageBoxRepository.findByStorageCode(storage.get());

        return boxList;
    }


    @GetMapping("/getStorageManger")
    public List<StorageManager> getStorageManger() {
        List<StorageManager> managerList = storageManagerRepository.findAll();

        return managerList;
    }

    @GetMapping("/getManager/{storageCode}")
    public List<StorageManager> getManager(@PathVariable(value = "storageCode") long storageCode){
        Optional<Storage> storage = storageRepository.findById(storageCode);
        List<StorageManager> managerList = storageManagerRepository.findByStorageCode(storage.get());
        return managerList;
    }

    // 각 보관함별 사용일 찾기
    @GetMapping("/findUseTime/{boxCode}")
    public List<UseStorageBox> findUseTime(@PathVariable(value = "boxCode")long storageBoxCode){
        Optional<StorageBox> box = storageBoxRepository.findById(storageBoxCode);
        List<UseStorageBox> useBox = useStorageBoxRepository.findByStorageBoxCode(box.get());
        return useBox;
    }

    //보관함 연장 결제
    @PostMapping("/renewalPay")
    public Result renewalPay(@RequestBody RenewalBox renewalBox){
        System.out.println(renewalBox.getBoxName());
        System.out.println(renewalBox.getStorageName());

        List<Member> user = memberRepository.findByMID(renewalBox.getUserId());
        Optional<Storage> storage = storageRepository.findByStorageName(renewalBox.getStorageName());
        Optional<StorageBox> storageBox = storageBoxRepository.findByStorageCodeAndStorageBoxName(storage.get().getStorageCode(), renewalBox.getBoxName());

        LocalDateTime start = renewalBox.getStartTime();
        LocalDateTime end = renewalBox.getEndTime();

        OrderList orderList = new OrderList(user.get(0));
        orderListRepository.save(orderList);

        UseStorageBox useStorageBox = new UseStorageBox(start,end,storageBox.get(), orderList);
        useStorageBoxRepository.save(useStorageBox);

//         박스 상태 변화
        storageBox.get().setStorageBoxState("1");
//         결제된 박스 업데이트
        storageBoxRepository.save(storageBox.get());

        return new Result("ok");
    }

    //보관함 계약 해지
    @PostMapping("/closeBox")
    public Result closeBox(@RequestBody RenewalBox renewalBox){
        Optional<Storage> storage = storageRepository.findByStorageName(renewalBox.getStorageName());
        Optional<StorageBox> storageBox = storageBoxRepository.findByStorageCodeAndStorageBoxName(storage.get().getStorageCode(), renewalBox.getBoxName());

        storageBox.get().setStorageBoxState("0");
        storageBoxRepository.save(storageBox.get());

        return new Result("ok");
    }

    // 보관함 결제
    @PostMapping("/payStorageBox")
    public Result payStorageBox(@RequestBody payStorageBox payStorageBox){

        List<Member> user = memberRepository.findByMID(payStorageBox.getUserId());
        Optional<StorageBox> storageBox = storageBoxRepository.findById(payStorageBox.getStorageBoxCode());

        LocalDateTime start = payStorageBox.getUseStorageStartTime();

        LocalDateTime end = payStorageBox.getUseStorageEndTime();

        OrderList orderList = new OrderList(user.get(0));
        orderListRepository.save(orderList);


        UseStorageBox useStorageBox = new UseStorageBox(start,end,storageBox.get(), orderList);
        useStorageBoxRepository.save(useStorageBox);

        // 박스 상태 변화
        storageBox.get().setStorageBoxState("1");
        // 결제된 박스 업데이트
        storageBoxRepository.save(storageBox.get());

        return new Result("ok");

    }

    //    로그인 없이 보관함 사용중인 사용자 조회
    @GetMapping("checkMember/{memberId}")
    public Object[] checkMember(@PathVariable("memberId")String memberId)  throws NoSuchElementException{
        try{
            Object[] useStorageBoxes = orderListRepository.findByMember(memberId);

            return useStorageBoxes;

        }catch (NoSuchElementException n){
            System.out.println(n);
            System.out.println("안돼");
            return null;
        }
    }


    //    로그인 없이 사용자 지정 할 때 사용
    @GetMapping("memberCheck/{memberId}")
    public Result getMemberId(@PathVariable(value = "memberId")String memberId) {
        List<Member> member = memberRepository.findByMID(memberId);
            return new Result("ok");
//        if(member.){
//            return new Result("ok");
//        }else{
//            return new Result("no");
//        }
    }

    //    로그인 없이 매니저 확인 할 때 사용
    @GetMapping("managerCheck/{managerId}")
    public Result getManagerCheck(@PathVariable(value = "managerId")String managerId) throws NoSuchElementException{
        try{
            List<Member> member = memberRepository.findByMID(managerId);
            Optional<StorageManager> storageManager = storageManagerRepository.findByMCode(member.get(0));

            if(storageManager.isPresent()){
                return new Result("ok");
            }else{
                return new Result("no");
            }
        }catch (NoSuchElementException n){
            System.out.println(n);
            return new Result("no");
        }
    }

    //    매니저가 관리하고 있는 보관소 불러오기
    @GetMapping("getManagerStorage/{managerId}")
    public List<StorageBox> getManagerStorage(@PathVariable(value = "managerId")String managerId) {
        List<Member> member = memberRepository.findByMID(managerId);
        Optional<StorageManager> storageManager = storageManagerRepository.findByMCode(member.get(0));
        List<StorageBox> storageBoxList = storageBoxRepository.findByStorageCode(storageManager.get().getStorageCode());

        return storageBoxList;
    }

    //    매니저가 관리하고 있는 보관소의 각 보관함 찾기
    @GetMapping("getBox/{storageBoxCode}")
    public Object[] getBox(@PathVariable(value = "storageBoxCode") long boxCode){
        System.out.println(boxCode);
        Optional<StorageBox> box = storageBoxRepository.findById(boxCode);
        System.out.println(box.get().getStorageBoxCode());

        Object[] object = storageBoxRepository.findByBoxInformation(box.get().getStorageBoxCode());
        if(object.length < 1){
            return new Optional[]{storageBoxRepository.findById(box.get().getStorageBoxCode())};
        }

        return object;
    }

}
