<template>
  <div class="storages-add">
    <div class="storage-add">
<!--          <input type="text" v-model="form.storageName" placeholder="보관소명">-->
<!--          <input type="text" v-model="form.storageZipcode" placeholder="우편번호">-->
<!--          <input type="text" v-model="form.storageAddress" placeholder="주소">-->
<!--          <button @click="postStorage()">ADD</button>-->

      <div class="form-floating mb-3">
        <input type="text" v-model="form.storageName" placeholder="보관소명" class="form-control" id="floatingName">
        <label for="floatingName">보관소명</label>
      </div>
      <div class="form-floating mb-3">
        <input type="text" v-model="form.storageZipcode" placeholder="우편번호" class="form-control" id="floatingZipcode">
        <label for="floatingZipcode">우편번호</label>
      </div>
      <div class="form-floating">
        <input type="text" v-model="form.storageAddress" placeholder="주소" class="form-control" id="floatingAddress">
        <label for="floatingAddress">주소</label>
      </div>
      <button class="storage-add-btn" @click="postStorage()">ADD</button>
    </div>



    <div class="storage-box">
      <p>보관함 추가</p>
      <p class="storage-box-p">{{name}}</p>
      <div class="storage-box-add">
        <table>
          <tbody>
          <tr>
            <td>small</td>
            <td>medium</td>
            <td>large</td>
            <td rowspan="2"><button class="storage-btn" @click="postBox">ADD</button></td>
          </tr>
          <tr>
            <td><button @click="subS" class="storage-add-sub">─</button>{{box.small}}<button @click="addS" class="storage-add-sub">+</button></td>
            <td><button @click="subM" class="storage-add-sub">─</button>{{box.medium}}<button @click="addM" class="storage-add-sub">+</button></td>
            <td><button @click="subL" class="storage-add-sub">─</button>{{box.large}}<button @click="addL" class="storage-add-sub">+</button></td>
          </tr>
          </tbody>
        </table>
      </div>
    </div>
  </div>
</template>

<script>
import axios from "axios";

export default {
  name: "StorageAdd",
  data() {
    return {
      box: {
        small: 0,
        medium: 0,
        large: 0,
        storageName: ''
      },
      form: {
        storageName: '',
        storageZipcode: '',
        storageAddress: ''
      },
      name:'',
      errorCheck: false,
      addStorage: false
    }
  },
  methods: {
    subS(){
      if(this.box.small == 0){
        this.box.small = 0
      }else{
        this.box.small--
      }
    },
    subM(){
      if(this.box.medium == 0){
        this.box.medium =0
      }else{
        this.box.medium--
      }
    },
    subL(){
      if(this.box.large == 0){
        this.box.large =0
      }else{
        this.box.large--
      }

    },
    addS(){
      this.box.small++
    },
    addM(){
      this.box.medium++
    },
    addL(){
      this.box.large++
    },
    inputCheck() {
      if (!this.form.storageName) {
        alert('보관소 명을 입력하세요')
      } else if (!this.form.storageZipcode) {
        alert('보관소 우편주소을 입력하세요')
      } else if (!this.form.storageAddress) {
        alert('보관소 주소을 입력하세요')
      } else {
        this.errorCheck = true
      }
    },
    clearInput() {
      this.form.storageName = ''
      this.form.storageZipcode = ''
      this.form.storageAddress = ''
    },
    claerBox(){
      this.box.small=0
      this.box.medium=0
      this.box.large=0
      this.box.storageName=''
    },
    postStorage() {
      this.inputCheck()
      if (this.errorCheck) {
        axios.post('api/postStorage', this.form)
            .then((res) => {
              console.log(this.form)
              console.log(res.data.result)
              if (res.data.result === 'ok') {
                alert('추가되었습니다')
                console.log('중복없음')
                this.box.storageName = this.form.storageName
                this.name = this.form.storageName
                this.clearInput()
                this.addStorage = true

              } else {
                console.log('중복')
              }
            }).catch((err) => {
          console.log(err)
        })
      }
    },
    postBox(){
      if(!this.addStorage) {
        alert('보관소를 먼저 추가하세요')
      }else if(this.box.small == 0 &&
          this.box.medium == 0 &&
          this.box.large == 0){
        alert('보관소를 추가하세요')
      }else {
        console.log(this.box)
        axios.post('api/postBox',this.box)
            .then((res)=>{
              console.log(res.data.result)
              this.claerBox()
              this.addStorage = false
              this.name=''
              alert('보관소와 보관함이 추가되었습니다.')
              this.$router.push('/storageAdmin')
            })
            .catch(error=>{
              console.log(error)
            })
      }
    }
  }
}
</script>

<style scoped>
.storages-add{
  width: 100%;
  height: 100%;
  text-align: center;
}
.storage-add{
  margin-top: 10%;
  width: 50%;
  display:flex;
  justify-content: center;
  margin-left: 25%;

}
.form-floating{
  margin-right: 5%;
}
.storage-add-btn{
  width: 10%;
  text-align: center;
  margin-left: 2%;
  margin-right: 3%;
  margin-bottom: 20%;
  padding: 1.5%;
  background-color: #ffffff;
  font-weight: bolder;
  color: #00a3de;
  border-color: #00a3de;
}
.storage-add-btn:hover{
  color: white;
  background-color: #b2e2fd;
}
.storage-box{
  padding-top: 1%;
  border: solid 3px #000a69;
  width: 50%;
  justify-content: center;
  align-items: center;
  margin-left: 25%;
  padding-bottom: 1%;
}
.storage-box-p{
  padding-bottom: 3%;
}
.storage-btn{
  text-align: center;
  margin-left: 2%;
  margin-right: 3%;
  margin-top: 10%;
  width: 45%;
  padding: 1.5%;
  background-color: #ffffff;
  font-weight: bolder;
  color: #00a3de;
  border-color: #00a3de;
}

.storage-btn:hover{
  color: white;
  background-color: #b2e2fd;
}
.storage-add-sub{
  background-color: #ffffff;
  color: #00a3de;
  border-color: #00a3de;
  border-radius: 1em;
}
.storage-add-sub:hover{
  color: white;
  background-color: #b2e2fd;
}

</style>