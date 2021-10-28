<template>
	<ul class="centence">
		<h2 class="title">所有的举报消息</h2>
		<li
			class="CenItem"
			is-dot
			v-for="item in indata"
			:key="item.inid"
			:data-inid="item.inid"
		>
			<sup
				v-show="item.instatus == 0"
				class="el-badge__content el-badge__content--undefined is-fixed is-dot"
			></sup>
			<span><b>被举报内容: </b> {{ item.cwtext }} </span>

			<span><b>举报人id:</b> {{ item.inuid }}</span>
			<br />
			<span><b>被举报人id: </b>{{ item.ineduid }}</span>
			<br />
			<span><b>被举报文案id:</b> {{ item.cwid }}</span>
			<br />
			<span>
				<b>是否处理:</b> {{ item.instatus == 0 ? "未处理" : "已处理" }}</span
			>
		</li>
	</ul>
</template>

<script>
import axios from "axios";
export default {
	name: "Allwarn",
	data() {
		return {
			warn: {
				informdata: {},
				toInformtext: "Inform who ID =  for he ..",
				informid: "",
			},
			indata: [],
		};
	},
	computed: {
		getindata() {
			return this.indata;
		},
	},
	methods: {
		// get 全部 inform
		getallinform() {
			axios({
				method: "get",
				url: "/queryAllInform",
			})
				.then((res) => {
					this.indata = res.data;
					console.log("dd");
					// this.getallinformCwtext();
					for (let i = 0; i < this.indata.length; i++) {
						const cwid = this.indata[i].cwid;
						const that = this;
						axios({
							method: "get",
							url: "/getcwbycwid",
							params: {
								cwid,
							},
						})
							.then((res) => {
								// console.log(res);
								that.getindata[i].cwtext = res.data.cwtext;
								console.log(that.getindata[i]);
							})
							.catch((err) => {
								console.log(err);
							});
					}
				})
				.catch((err) => {
					console.log(err);
				});
			// console.log(1);
		},
		getallinformCwtext() {
			for (let i = 0; i < this.indata.length; i++) {
				const cwid = this.indata[i].cwid;
				const that = this;
				axios({
					method: "get",
					url: "/getcwbycwid",
					params: {
						cwid,
					},
				})
					.then((res) => {
						// console.log(res);
						that.indata[i].cwtext = res.data.cwtext;
						if (i === that.indata.length - 1) {
							this.issolveInformShow = true;
						}
						this.issolveInformShow = false;
					})
					.catch((err) => {
						console.log(err);
					});
				location.reload();
			}
		},
	},
	mounted() {
		if (localStorage.uid) {
			this.getallinform();
		}
	},
};
</script>

<style scoped>
@import url("../../assets/css/base.css");

/*                           历史文案                  */

.centence {
	width: 100%;
	display: flex;
	flex-wrap: wrap;
	box-sizing: border-box;
	padding: 1% 1%;
	border-radius: 8px;
}
.CenItem {
	position: relative;
	border-bottom: 1px solid rgb(161, 115, 207);
	color: #444;
	width: 100%;
	padding: 10px 15px 3px 0;
	margin: 4px 8px;
	text-align: left;
}
.CenItem span {
	font-size: 14px;
	display: block;
	padding-right: 10px;
	width: calc(100% - 10rem);
}
.CenItem > span {
	margin: 4px 0 0;
	float: left;
}
.CenItem > span b {
	font-size: 14px;
	color: #aaa;
	width: 20%;
	float: left;
	text-align: right;
	margin-right: 0.625rem;
	/* cursor: pointer; */
}
/* .CenItem > p b:hover {
	color: #000;
} */
.CenItem:hover .showof {
	opacity: 1;
}
.CenItem .showof {
	opacity: 0;
	top: 0;
	right: 0;
	position: absolute;
	display: inline-block;
	cursor: pointer;
	width: 5rem;
	height: 100%;
	background-color: rgba(0, 0, 0, 0.2);
	text-align: center;
	transition: all 0.3s;
}
.CenItem .showof:hover {
	background-color: rgba(0, 0, 0, 0.5);
}

.CenItem .showof i {
	position: absolute;
	top: 50%;
	left: 50%;
	transform: translate(-50%, -50%);
}

.CenItem:hover .time {
	display: none;
}
.CenItem .time {
	display: block;
	width: 5rem;
	position: absolute;
	color: #777;
	font-size: 12px;
	right: 0.9375rem;
	bottom: 0.625rem;
}

.solveInformBox textarea {
	position: relative;
	left: 50%;
	transform: translate(-50%, -0%);
}
input {
	outline: none;
}
.selectInform {
	width: 80%;
	margin: 0 auto;
	height: 2.1875rem;
}
.selectInform .el-input__inner {
	width: 50px;
}
</style>