<template>
	<div class="perinformation">
		<div class="button">
			<button v-if="isedit" class="edit" @click="edit()">edit</button>
			<button v-if="issubmit" class="edit" @click="submit()">submit</button>
		</div>

		<div class="information">
			<div class="facebig userface">
				<img :src="this.user.userface" alt="" />
				<b class="line"></b>
			</div>
			<div class="letters">
				<ul>
					<li>
						<span>用户id:</span>
						<span class="userID">{{ this.user.userID }}</span>
					</li>
					<li>
						<span>邮箱:</span>
						<span class="useremail"> {{ this.user.useremail }} </span>
					</li>
					<li>
						<span>用户名:</span>
						<span class="cwuname"> {{ this.user.cwuname }} </span>
					</li>
					<li>
						<span>性别:</span>
						<span class="sexValue">{{ this.user.sexValue }}</span>
					</li>
					<li>
						<span>违规次数:</span>
						<span class="illegalTime"> {{ this.user.illegalTime }} </span>
					</li>
					<li>
						<span>账号状态:</span>
						<span class="userstatue"> {{ this.user.userstatue }} </span>
					</li>
				</ul>
			</div>
		</div>
	</div>
</template>

<script>
import { getChangeValues, toEdit, toSubmit } from "./edit";
export default {
	name: "Perinformation",
	data() {
		return {
			isedit: true,
			issubmit: false,
			user: {
				userID: "",
				useremail: "",
				cwuname: "",
				sexValue: "",
				illegalTime: "",
				userstatue: "",
				userface: "",
			},
		};
	},
	methods: {
		edit() {
			this.$confirm("确定要修改个人信息？", "tip", {
				type: "warning",
			}).then(({ result }) => {
				if (result) {
					this.$toast.message("选择了确定！");
					this.isedit = false;
					this.issubmit = true;
					const params = ["cwuname", "sexValue", "useremail"];
					toEdit("edit", params);
				} else {
					this.$toast.message("取消修改。");
				}
			});
		},
		submit() {
			this.isedit = true;
			this.issubmit = false;
			const params = ["cwuname", "sexValue", "useremail"];
			const userval = getChangeValues(params);
			// toSubmit(params, values);
			for (let key in userval) {
				this.user[key] = userval[key];
				localStorage.setItem(key, userval[key]);
			}
			console.log(localStorage);
			this.$toast.success("修改成功！");
		},
	},
	mounted() {
		for (let key in this.user) {
			this.user[key] = localStorage[key];
		}
	},
};
</script>

<style scoped>
@import url("../../assets/css/base.css");

/*                        个人资料                              */

.information {
	display: flex;
	padding: 2% 10%;
	border: rgb(156, 156, 255) dashed 1px;
}
.information > div {
	flex: 1;
	text-align: center;
}
.Personal b.line {
	display: inline-block;
	width: 3px;
	border-right: 2px solid rgb(161, 115, 207);
	position: relative;
	left: 1.6em;
	height: 90%;
	border-radius: 3em/100em;
	top: 50%;
	transform: translate(0, -50%);
	width: 2px;
}

.information > div:nth-of-type(2) {
	flex: 2;
}
.facebig img {
	width: 90%;
	max-width: 12em;

	border-radius: 100em;
	border: 1px solid rebeccapurple;
}
.letters {
	flex: 2;
}

.letters ul > li {
	display: flex;
	height: 2.1em;
	line-height: 2.1em;
}
.letters ul > li > span {
	padding: 1% 2%;
	flex: 1;
	text-align: right;
	/* font-size: 1.2em; */
	color: #111;
}
.letters ul > li > span:nth-of-type(2) {
	flex: 2;
	text-align: left;
	font-family: "KaTi_GB2312";
	color: #333;
	white-space: nowrap;
	overflow: hidden;
	text-overflow: ellipsis;
}
.editinput,
input {
	width: 80%;
	height: 2.4em;
	font-size: 0.8em;
	padding: 0 10px;
	line-height: 2.4em;
	color: #777;
	border: #111 1px solid;
	border-radius: 8px;
}
</style>