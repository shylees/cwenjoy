<template>
	<ul class="centence">
		<h2 class="title">警告消息</h2>
		<li class="CenItem" is-dot v-for="item in this.indata" :key="item.inid">
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
				@click="
					(issolveInformShow = true),
						(Informids[0] = item.ineduid),
						(Informids[1] = item.inuid),
						(toInformid = item.ineduid)
				"
				><i>处理警告</i></b
			>

			<el-dialog
				class="solveInformBox dialogBox"
				:visible.sync="issolveInformShow"
				width="40%"
			>
				<mu-container>
					<mu-form
						:model="warn"
						class="mu-demo-form"
						label-position="left"
						label-width="100"
					>
						<mu-form-item label="编辑警告信息">
							<mu-text-field v-model="warn.toInformtext"></mu-text-field>
						</mu-form-item>
						<mu-form-item label="选择警告的人">
							<mu-select v-model="warn.toInformid" full-width>
								<mu-option
									v-for="item in warn.Informids"
									:key="item"
									:label="item"
									:value="item"
								></mu-option>
							</mu-select>
						</mu-form-item>
					</mu-form>
				</mu-container>

				<span slot="footer" class="dialog-footer">
					<el-button
						class="cancel"
						@click="(issolveInformShow = false), $toast.message('选择了取消。')"
						>取 消</el-button
					>
					<el-button
						class="confirm"
						type="primary"
						@click="(issolveInformShow = false), $toast.success('已发布警告！')"
						>确 定</el-button
					>
				</span>
			</el-dialog>
		</li>
	</ul>
</template>

<script>
export default {
	name: "Warnmess",
	data() {
		return {
			issolveInformShow: false,
			toInformid: "1",
			warn: {
				Informids: [],
				toInformtext: "",
			},
			indata: [
				{
					inid: "1",
					ineduid: "2",
					inuid: "1",
					cwid: "1",
					instatus: "1",
					cwtext: "用绝对清醒的理智，压制不该有的情绪",
				},
				{
					inid: "2",
					ineduid: "2",
					inuid: "1",
					cwid: "2",
					instatus: "0",
					cwtext: "时间会在眨眼间流逝，顺其自然还是用尽全力？",
				},
			],
		};
	},
	methods: {
		confirmDelete() {
			this.$confirm("确定要删除该文案？", "tip", {
				type: "warning",
			}).then(({ result }) => {
				if (result) {
					this.$toast.success("删除成功！");
				} else {
					this.$toast.message("取消删除。");
				}
			});
		},
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