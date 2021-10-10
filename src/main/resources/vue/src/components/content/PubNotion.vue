<template>
	<div class="publishNotion publishBox dialogBox" width="40%">
		<h2 class="title">发布公告</h2>
		<mu-form
			:model="notion"
			class="mu-demo-form"
			label-position="left"
			label-width="100"
		>
			<mu-form-item prop="input" label="公告信息:">
				<mu-text-field
					v-model="notion.toNotiontext"
					ref="notionval"
				></mu-text-field>
			</mu-form-item>
			<mu-form-item prop="radio" label="公告类型:">
				<mu-radio v-model="notion.notiontype" value="0" label="更新"></mu-radio>
				<mu-radio v-model="notion.notiontype" value="1" label="警告"></mu-radio>
			</mu-form-item>
		</mu-form>

		<span slot="footer" class="dialog-footer">
			<button class="cancel" @click="$toast.message('选择了取消。')">
				取 消
			</button>
			<button class="confirm" type="primary" @click="publishNotion">
				确 定
			</button>
		</span>
	</div>
</template>

<script>
import axios from "axios";

export default {
	name: "PubNotion",
	data() {
		return {
			notion: {
				notiontype: "0",
				toNotiontext: "",
			},
		};
	},
	methods: {
		publishNotion() {
			if (!this.$refs.notionval) {
				this.$toast.warning("公告信息不能为空！");
			} else {
				const ntype = this.notion.notiontype;
				// const ncontext = this.notion.ncontext;
				const ncontext = this.$refs.notionval.value;
				// console.log(this.notion);

				axios({
					method: "post",
					url: "/addnotion",
					data: {
						ncontext,
						ntime: Date.parse(new Date()),
						ntype,
					},
					headers: {
						"Access-Control-Allow-Origin": "*",
					},
				})
					.then((res) => {
						if (res.data > 0) {
							this.$toast.success("已发布公告！");
							location.reload();
						}
					})
					.catch((err) => {
						console.log(err);
					});
			}
		},
	},
};
</script>

<style socped>
/* 不知道为什么这里不能有 否侧提示框会有问题 */
/* @import url("../../assets/css/base.css"); */

.publishNotion {
	/* background-color: #fbfbfb; */
	width: 80%;
	margin: 0 auto;
}
.title {
	width: 100%;
	height: 4rem;
	font-weight: 700;
	line-height: 4rem;
	font-size: 1.1rem;
	color: rgb(11, 11, 167);
	text-align: center;
	letter-spacing: 2px;
	font-family: Gabriola;
}

input {
	height: 2.4em;
	font-size: 0.8em;
	padding: 0 10px;
	line-height: 2.4em;
	color: #777;
	border: #111 1px solid;
	border-radius: 8px;
}

.button {
	width: 100%;
	height: 3em;
	position: relative;
}

button {
	background-color: rgb(230, 230, 250);
	outline: none;
	/* background-color: rgb(107, 107, 165); */
	width: 4em;
	height: 1.8em;
	line-height: 2em;
	/* padding: 0.5% 1em; */
	font-size: 14px;
	border-radius: 12px;
	/* border: 1px solid #555; */
	position: absolute;
	right: 0;
	transform: translateX(-60%);
	border: none;
}
button:hover {
	background-color: rgba(230, 230, 250, 0.68);
}
.dialogBox .cancel {
	left: 0;
	transform: translateX(0%);
}

.dialogBox .confirm {
	position: absolute;
	transform: translateX(-0%);
}

.dialogBox button:hover {
	color: #000;
	/* font-weight: 700; */
	/* background: ; */
	box-shadow: 0 0 10px 5px rgba(0, 0, 0, 0.08);
	background-color: rgb(230, 230, 250);
}

.publishNotion div.mu-input-line {
	background-color: rgba(0, 0, 0, 0.12);
}
.publishNotion div.mu-input-focus-line {
	background-color: rgb(51, 51, 51);
}
.mu-radio-label {
	/* width: 3.125rem; */
	/* color: #000; */
	font-size: 15px;
	text-align: left;
	margin-left: 5px;
}
.dialogBox .dialog-footer {
	transform: translateY(-40%);
	/* border: #333 1px solid; */
	width: 50%;
	height: 2.2em;
	position: relative;
	display: block;
	margin: 0 auto;
	font-size: 13px;
}
</style>