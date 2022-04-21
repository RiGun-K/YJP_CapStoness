<template>
	<h2>일정작성</h2>
	<h2>{{ this.$store.state.diff - 1 }}박{{ this.$store.state.diff }}일</h2>

	<div v-for="index in this.$store.state.diff" :key="index">
		<button @click="datesButton(index)">{{ index }}</button>일차
		<br />
	</div>

	<hr />
	<h1>{{ dateIndex }}일차 계획</h1>
	시작
	<input type="time" v-model="detailStart" /><br />
	종료
	<input type="time" v-model="detailEnd" />
	<br />
	Name<input
		type="text"
		v-model="detailName"
		placeholder="일정 이름을 입력하세요"
	/>
	<br />

	Memo<input
		type="text"
		v-model="detailMemo"
		placeholder="메모를 입력하세요"
	/>
	<br />

	<div v-for="(value, index) in showChecklist" :key="index">
		<h2>{{ value }}</h2>
	</div>
	<button @click="insert">삽입</button>
	<hr />

	<div>
		<table border="1" bordercolor="blue" align="center">
			<th bgcolor="skybule">{{ dateIndex }}일차</th>

			<th>시작</th>
			<th>종료</th>
			<th>이름</th>
			<th>메모</th>
			<th>체크리스트</th>
			<tr v-for="(value, index) in detailPlanOfDayList" :key="index">
				<td></td>
				<td>{{ value.detailStart }}</td>
				<td>{{ value.detailEnd }}</td>
				<td>{{ value.detailName }}</td>
				<td>{{ value.detailMemo }}</td>
				<td>
					<ul v-for="(value1, index) in checklistList" :key="index">
						<button
							v-if="
								value.detailCode == value1.detailCode.detailCode
							"
						>
							{{ value1.checkContent }}
						</button>
					</ul>
				</td>
				<td>
					<button @click="insertChecklist(value.detailCode)">
						checkList
					</button>
				</td>
			</tr>
		</table>
	</div>
</template>

<script>
import axios from 'axios';
export default {
	created() {
		this.loadDetailPlanOfDay(1);
	},
	data() {
		return {
			detailStart: '',
			detailEnd: '',
			planList: '',
			detailName: '',
			detailMemo: '',
			detailDay: '',
			dateIndex: '',
			putChecklist: '',
			showChecklist: [],
			detailPlanOfDayList: [],
			checklistList: [],
		};
	},
	methods: {
		datesButton: function (index) {
			this.detailPlanOfDayList.length = 0;
			this.dateIndex = index;
			this.loadDetailPlanOfDay(index);
		},
		loadDetailPlanOfDay: function (index) {
			const url = '/api/loadDetailPlanOfDay';
			this.detailPlanOfDayList.length = 0;
			axios
				.post(url, {
					detailDay: index,
					planCode: this.$store.state.planCode,
				})
				.then((response) => {
					response.data.map((item) => {
						console.log(item.checklists);
						this.detailPlanOfDayList.push(item);
						return console.log(item);
					});
				});
		},
		insertChecklist: function (detailCode) {
			const planDetail = { detailCode: detailCode };
			const checkContent = prompt('체크리스트를 추가하세요!', 'ex) 휴지');
			const url = '/api/insertChecklist';

			axios
				.put(url, {
					detailCode: planDetail,
					checkContent: checkContent,
				})
				.then((response) => {
					console.log('성공');
					this.loadChecklist(detailCode);
				})
				.catch((error) => {
					console.log(error);
				});
		},
		loadChecklist: function (detailCode) {
			this.checklistList.length = 0;
			const url = '/api/loadChecklist';
			const planDetail = { detailCode: detailCode };
			axios
				.post(url, {
					detailCode: planDetail,
				})
				.then((response) => {
					response.data.map((item) => {
						this.checklistList.push(item);
						console.log(item);
						return console.log(item);
					});
				})
				.catch((error) => {
					console.log(error);
				});
		},
		insert: function () {
			const url = '/api/insertDetailPlan';
			// const data = {
			// 	detailStart: this.detailStart,
			// 	detailEnd: this.detailEnd,
			// 	detailMemo: this.detailMemo,
			// 	detailDay: this.dateIndex,
			// 	planCode: this.$store.state.planCode,
			// };
			console.log(this.detailStart);
			console.log(this.detailEnd);
			console.log(this.detailMemo);
			console.log(this.dateIndex);
			console.log(this.$store.state.planCode);
			axios
				.put(url, {
					detailStart: this.detailStart,
					detailEnd: this.detailEnd,
					detailMemo: this.detailMemo,
					detailDay: this.dateIndex,
					planCode: this.$store.state.planCode,
					detailName: this.detailName,
				})
				.then((response) => {
					this.loadDetailPlanOfDay(this.dateIndex);
					console.log('success');
				})
				.catch((error) => {
					console.log(error);
				});
		},
	},
};
</script>

<style></style>
