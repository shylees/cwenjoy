<template>
	<ul class="centence">
		<h2 class="title">未处理的举报消息</h2>
		<li
			class="CenItem"
			is-dot
			v-for="item in indata"
			:key="item.inid"
			:data-inid="item.inid"
			v-if="item.ineduid != 1"
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
			<b
				class="solveInform showof"
				v-if="item.instatus == 0"
				color="success"
				@click="solveInform($event)"
				><i>处理举报</i></b
			>

			<el-dialog
				class="solveInformBox dialogBox"
				:visible.sync="issolveInformShow"
				width="40%"
			>
				<mu-container>
					<mu-form
						v-if="warn.informdata[0]"
						:model="warn"
						class="mu-demo-form"
						label-position="left"
						label-width="100"
					>
						<mu-form-item label="编辑警告信息">
							<mu-text-field
								v-model="warn.toInformtext"
								value="warn.toInformtext"
								ref="warnval"
							>
							</mu-text-field>
						</mu-form-item>
						<mu-form-item label="选择警告的人">
							<mu-radio
								v-model="warn.informid"
								label="被举报的人id"
								:value="warn.informdata[0].ineduid"
							></mu-radio>
							<mu-radio
								v-model="warn.informid"
								:value="warn.informdata[0].inuid"
								label="举报人id"
							></mu-radio>
						</mu-form-item>
					</mu-form>
				</mu-container>

				<span slot="footer" class="dialog-footer">
					<el-button
						class="cancel"
						@click="(issolveInformShow = false), $toast.message('选择了取消。')"
						>取 消</el-button
					>
					<el-button class="confirm" type="primary" @click="confirmInform"
						>确 定</el-button
					>
				</span>
			</el-dialog>
		</li>
	</ul>
</template>

<script>
import axios from "axios";
export default {
	name: "Warnmess",
	data() {
		return {
			issolveInformShow: false,

			warn: {
				informdata: {},
				toInformtext: "Inform who ID =  for he ..",
				informid: "",
			},
			indata: [],
		};
	},
	methods: {
		// get 全部 inform
		getallinform() {
			axios({
				method: "get",
				url: "/getallinformbystatusz",
			})
				.then((res) => {
					this.indata = res.data;
					this.getallinformCwtext();
				})
				.catch((err) => {
					console.log(err);
				});
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
			}
		},

		// 处理 警告
		solveInform(e) {
			this.issolveInformShow = true;
			this.warn.informdata = this.indata.filter(
				(item) => item.inid == e.currentTarget.parentElement.dataset.inid
			);
		},

		// 发布 警告
		confirmInform() {
			this.issolveInformShow = false;

			if (!this.warn.toInformtext) {
				this.$toast.warning("警告信息不能为空！");
			} else if (!this.warn.informid) {
				this.$toast.warning("警告人id不能为空！");
			} else {
				const that = this;
				const inid = this.warn.informdata[0].inid;
				const ncontext = this.$refs.warnval[2].value;
				axios({
					method: "post",
					url: "/addnotion",
					data: {
						ncontext,
						ntime: Date.parse(new Date()),
						ntype: "1",
					},
					headers: {
						"Access-Control-Allow-Origin": "*",
					},
				})
					.then((res) => {
						if (res.data > 0) {
							that.changeinformstatus(inid);
							this.$toast.success("已发布警告！");
						}
					})
					.catch((err) => {
						console.log(err);
					});
			}
		},

		// 修改 举报信息的 状态
		changeinformstatus(inid) {
			const id = inid;
			axios({
				method: "get",
				url: "/updateinformsolvestatus",
				params: { inid: id },
				headers: {
					"Access-Control-Allow-Origin": "*",
				},
			})
				.then((res) => {
					location.reload();
				})
				.catch((err) => {
					console.log(err);
				});
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