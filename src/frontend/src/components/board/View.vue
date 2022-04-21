<template>
  <div>
    <H1>게시판 상세보기</H1>
    <div class="AddWrap">
      <form>
        <table class="tbAdd">
          <colgroup>
            <col width="15%" />
            <col width="*" />
          </colgroup>
          <tr>
            <th>글쓴이</th>
            <td>{{List.mid.mid}}</td>
          </tr>
          <tr>
            <th>제목</th>
            <td>{{ List.title }}</td>
          </tr>
          <tr>
            <th>내용</th>
            <td>{{ List.content }}</td>
          </tr>

        </table>
      </form>
    </div>
  </div>


  <div class="dap_ins">
      <div style="margin-top:30px; ">
        <textarea name="content" class="reply_content" id="re_content" ></textarea>
        <button id="rep_bt" class="re_bt">댓글</button>
      </div>

  </div>
  <div id="foot_box"></div>

    <div class="btnWrap">
      <button @click="list" class="btn" style="float: left;">목록</button>

      <button @click="updateData(List)" class="btn" style="float: left;" v-if="ch">수정</button>
      <button @click="deleteData" class="btn" style="float: left;" v-if="ch">삭제</button>
    </div>
</template>

<script>
import axios from "axios"
import Read from "@/components/board/Read";
import store from "@/store";

export default {
  name: 'View',
  data() {
    return {
      writer_code: '',
      title: '',
      content: '',
      List: [],
      ch:true
    }
  },
  created() {
    this.DataList();
  },

  methods: {
    check(){
      if(store.getters.getLoginState.loginState == this.List.mid.mid){
        return true
      }else{
        return false
      }
    },
    DataList() {
      this.id = this.$route.params.writer_code;
      console.log(this.id);
      console.log(this.id);
      axios.get('/api/myList/' + this.id)
          .then((res) => {
            console.log("내가 받은 데이터는", res.data)
            this.List = res.data;
            this.ch = this.check()
            console.log(this.List.writer_code)
          })
          .catch(error => {
            console.log("에러" + error)
          })

    },

    deleteData() {
      if (confirm("삭제하시겠습니까?")) {
        axios.delete('/api/deleteList/'+ this.id)
            .then((res) => {
              console.log("삭제되었습니다.", res)
              alert("게시글이 삭제되었습니다.")
              this.$router.push({
                path: '/read'
              })
            })
            .catch((err) => {
              console.log(err)
            })
      }

    },
    updateData(List) {
        console.log(List.mid.mid, List.title, List.content);
        this.$router.push({
          path: `/update/${List.writer_code}`,
          query: {
            writer_code: List.writer_code,
            title: List.title,
            content: List.content
          }
        })

    },
    list() {
      this.$router.push({
        path: '/read'
      })
    }

  }
}

</script>

<style scoped>
.tbAdd{border-top:1px solid #888;}
.tbAdd th, .tbAdd td{border-bottom:1px solid #eee; padding:5px 0; }
.tbAdd td{padding:10px 10px; box-sizing:border-box; text-align:left;}
.tbAdd td.txt_cont{height:300px; vertical-align:top;}
.btnWrap{text-align:center; margin:20px 0 0 0;}
.btnWrap a{margin:0 10px;}
.btnAdd {background:#43b984}
.btnDelete{background:#f00;}

.btn {
  margin: 10px;
}
.dap_ins {
  margin-top:50px;
}
.re_bt {
  position: absolute;
  width:100px;
  height:56px;
  font-size:16px;
  margin-left: 10px;
}

#re_content {
  width:700px;
  height: 56px;
}

#foot_box {
  height: 50px;
}

</style>