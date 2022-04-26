<template>
  장비 이동
  현재 보관중인 보관함 위치
  이동할 보관소 or 주소 입력
  <br>
  <input type="radio" name="move-option" v-model="moveOption" value="round">장소 <br>
  <input type="radio" name="move-option" v-model="moveOption" value="storage">보관함
  {{ moveOption }}
  <div v-if="moveOption=='round'"><!--장소 검색-->
    <input type="text" v-model="zipCode">우편주소
    <button @click="showApi()">우편번호 찾기</button>
    <input type="text" v-model="address">주소
    <input type="text" v-model="detailAddress">상세주소
    <hr>
    <div id="map"></div>

  </div>
  <div v-if="moveOption=='storage'"><!--보관함-->
      <UserStorageView></UserStorageView>
  </div>
</template>

<script>
import UserStorageView from "@/views/user/UserStorageView.vue";
export default {
  name: "MoveBox",
  components: {
    UserStorageView
  },
  data() {
    return {
      map: null,
      zipCode: '',
      address: '',
      detailAddress: '',
      moveOption: ''
    }
  }, mounted() {
    if (window.kakao && window.kakao.maps) {
      this.initMap();
    } else {
      const script = document.createElement("script");
      /* global kakao */
      script.onload = () => kakao.maps.load(this.initMap);
      script.src =
          "//dapi.kakao.com/v2/maps/sdk.js?autoload=false&appkey=8a536388b1cc33e00ae2dbf18b8509ba";
      document.head.appendChild(script);
    }
  },
  methods: {
    showApi() {
      new window.daum.Postcode({
        oncomplete: (data) => {

          this.zipCode = data.zonecode
          this.address = data.roadAddress
        }
      }).open({popupKey: '주소검색'})
    },
    initMap() {
      const container = document.getElementById("map");
      const options = {
        center: new kakao.maps.LatLng(33.450701, 126.570667),
        level: 5,
      };

      this.map = new kakao.maps.Map(container, options);
    },

    // initMap() {
    //   const container = document.getElementById("map");
    //   const options = {
    //     center: new kakao.maps.LatLng(35.89527721605076, 128.62277217540984),
    //     level: 8,
    //   };
    //   this.map = new kakao.maps.Map(container, options);
    //   console.log(this.map)
    //   console.log("33")
    //   // 장소 검색 객체를 생성합니다
    //   // var ps = new kakao.maps.services.Places();
    //
    //   // 키워드로 장소를 검색합니다
    //   // ps.keywordSearch('이태원 맛집', this.placesSearchCB);
    //
    // },
    // // 키워드 검색 완료 시 호출되는 콜백함수 입니다
    // placesSearchCB (data, status, pagination) {
    //   if (status === kakao.maps.services.Status.OK) {
    //
    //     // 검색된 장소 위치를 기준으로 지도 범위를 재설정하기위해
    //     // LatLngBounds 객체에 좌표를 추가합니다
    //     var bounds = new kakao.maps.LatLngBounds();
    //
    //     for (var i=0; i<data.length; i++) {
    //       this.displayMarker(data[i]);
    //       bounds.extend(new kakao.maps.LatLng(data[i].y, data[i].x));
    //     }
    //
    //     // 검색된 장소 위치를 기준으로 지도 범위를 재설정합니다
    //     map.setBounds(bounds);
    //   }
    // },
    //
    // displayMarker(place) {
    //
    //   // 마커를 생성하고 지도에 표시합니다
    //   var marker = new kakao.maps.Marker({
    //     map: map,
    //     position: new kakao.maps.LatLng(place.y, place.x)
    //   });
    //
    //   // 마커에 클릭이벤트를 등록합니다
    //   kakao.maps.event.addListener(marker, 'click', function() {
    //     // 마커를 클릭하면 장소명이 인포윈도우에 표출됩니다
    //     infowindow.setContent('<div style="padding:5px;font-size:12px;">' + place.place_name + '</div>');
    //     infowindow.open(map, marker);
    //   });
    // }
  }
}
</script>

<style scoped>
#map {
  width: 400px;
  height: 400px;
}
</style>