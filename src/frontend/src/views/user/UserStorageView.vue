<template>
  <div class="user-storage-view">
    <h3>보관소 리스트 페이지</h3>
    <div class="storage-get">
      <div v-for="(storage,index) in storageList" :key="index" @click="GetStorageDetail(storage.storageCode)" style="margin-bottom: 3%">
        <div class="card" style="width: 35%; font-weight: bolder; margin-left: 7%">
          <div class="card-body">
            이름: {{ storage.storageName }}
          </div>
          <div class="card-body">
            주소: {{ storage.storageAddress }}
          </div>
        </div>
      </div>
    </div>
    <div v-if="check">
      <div class="storage">
        <div class="storage-name-btn">
          <h5 class="storage-name-h5">보관소 이름: {{ name }}</h5>

          <button @click="askBox(this.memberId, this.boxList[1].storageCode.storageCode)" class="storage-submit-btn">신청</button>
          <button @click="closeDetail" class="storage-submit-btn">닫기</button>
        </div>
          <div class="storage-view">
            <div class="storage-box" v-for="(box,index) in boxList" :key="index">
              <ul>
                <li>보관함 이름: {{ box.storageBoxName }}</li>
                <li>보관함 상태:<p v-if="box.storageBoxState == '0'">사용가능</p>
                  <p v-else-if="box.storageBoxState == '1' ">사용불가능</p>
                </li>
              </ul>
            </div>
        </div>
      </div>
    </div>
  </div>
</template>

<script>
import axios from "axios";
import store from "@/store";

export default {
  name: "UserStorageView",
  components: {},
  created() {
    axios.get('/api/getStorage')
        .then((res) => {
          console.log(res)
          console.log(res.data)
          this.storageList = res.data

          console.log('ALL this.storageList')
          console.log(this.storageList)
        })
        .catch((error) => {
          console.log(error)
        })
  },
  mounted() {
    this.memberId = store.getters.getLoginState.loginState
  },
  data() {
    return {
      storageList: [],
      check: false,
      boxList: [],
      name: '',
      memberId:''
    }
  },
  methods: {

    GetStorageDetail(storageCode) {
      this.detailCheck()
      axios.get('/api/storageView/' + storageCode)
          .then((resp) => {
            console.log(resp.data)
            this.boxList = resp.data
            this.name = this.boxList[0].storageCode.storageName
          })
          .catch((err) => {
            console.log(err)
          })
    },
    detailCheck() {
      if (!this.check) {
        this.check = !this.check
      }
    },
    closeDetail() {
      if (this.check) {
        this.check = !this.check
      }
    },
    askBox(memberId, storageCode){
      console.log('보관소 코드')
      console.log(storageCode)
      this.$router.push({name:'userStorageDetail', params:{storageCode:storageCode, memberId:memberId}})
    }

  }

}
</script>

<style scoped>
.user-storage-view{
  width: 100%;
  height: 100%;
}
.user-storage-view h3{
  margin-top: 3%;
  margin-left: 7%;
  margin-bottom: 5%;
}
.card-body{
  padding: 3%;
}
.storage-box {
  border: solid 3px #00a3de;
  border-radius: 10px;
  width: 30%;
}
.storage-view {
  display: -webkit-flex;
  display: flex;
}

.storage {
  border: solid 3px #000a69;
  margin-left: 7%;
  width: 50%;
  padding-top: 2%;
  padding-bottom: 2%;
}
.storage-name-h5{
  margin-left: 2%;
  margin-top: 2%;
  font-weight: bolder;
  width: 40%;
}
.storage-name-btn{
  display: flex;
  width: 100%;
  height: 30%;
}
.storage-submit-btn{
  margin: 2% -30% 2% 33%;
  text-align: center;
  width: 10%;
  background-color: #ffffff;
  font-weight: bolder;
  color: #00a3de;
  border-color: #00a3de;
}
.storage-submit-btn:hover{
  color: white;
  background-color: #b2e2fd;
}
</style>