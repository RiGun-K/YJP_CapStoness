<template>
  box상태를 상세히 확인 할 수 있다
  <div v-if="chk">
    <table>
      <tbody>
      <tr>
        <td>보관함</td>
        <td>{{ box.boxName }}</td>
      </tr>
      <tr>
        <td>상태</td>
        <td v-if="box.boxState == 1">사용중</td>
      </tr>
      <tr>
        <td>사용중인 사용자</td>
        <td>{{ box.userName }}</td>
      </tr>
      </tbody>
    </table>
  </div>
  <div v-else>
    <table>
      <tbody>
      <tr>
        <td>보관함</td>
        <td>{{ box.storageBoxName }}</td>
      </tr>
      <tr>
        <td>상태</td>
        <td>사용안함</td>
      </tr>
      </tbody>
    </table>
  </div>
</template>

<script>
import axios from "axios";

export default {
  name: "BoxMadalDetail",
  props:{
    boxCode:null
  },
  mounted() {
    this.getd()

  },
  methods:{
    getd(){
      this.box={}
      axios.get('/api/getBox/'+ this.boxCode)
          .then(res=>{
            if(res.data[0].length > 2){
              const data={
                userName:'',
                boxCode:'',
                boxName:'',
                boxState:'',
                storageCode:''
              }
              const datak = res.data[0]
              data.userName = datak[0]
              data.boxCode = datak[1]
              data.boxName = datak[2]
              data.boxState = datak[3]
              data.boxType = datak[4]
              data.storageCode = datak[5]
              this.box = data
              this.chk = true
            }else{
              this.box = res.data[0]
              this.chk = false
            }
            console.log(this.box)
          })
          .catch(err=>{
            console.log(err)
          })
    }
  },
  watch: {
    boxCode(){
      this.getd()

    }
  },
  data(){
    return{
      chk:false,
      box:{}
    }
  }
}
</script>

<style scoped>

</style>