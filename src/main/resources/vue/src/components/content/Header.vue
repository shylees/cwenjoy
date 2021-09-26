<template>
	<div class="header">
		<div class="logo">
			<img src="../../assets/logo.jpg" alt="" title="cwenjoy" />
		</div>

		<div class="publish">
			<el-button class="publishBtn" type="text" @click="dialogVisible = true"
				>publish</el-button
			>

			<el-dialog class="publishBox" :visible.sync="dialogVisible" width="50%">
				<textarea
					name="publishBoxContent"
					cols="40"
					rows="5"
					placeholder="分享你的文案吧！"
					ref="textA"
				></textarea>

				<span slot="footer" class="dialog-footer">
					<el-button class="cancel" @click="dialogVisible = false"
						>取 消</el-button
					>
					<el-button
						class="confirm"
						type="primary"
						@click="dialogVisible = false"
						>确 定</el-button
					>
				</span>
			</el-dialog>
		</div>
		<div class="userface">
			<img src="../../assets/img/users/stu1.jpg" alt="" title="username" />
		</div>
	</div>
</template>

<script>
import Publish from "./Publish.vue";

export default {
	name: "Header",
	props: ["tabbar"],
	components: {
		Publish,
	},
	data() {
		return {
			isPublish: false,
			dialogVisible: false,
		};
	},
	methods: {},
	computed: {},
};
</script>

<style scoped>
@import "../../assets/css/base.css";

.header {
	display: flex;
	position: relative;
	top: 0;
	right: 0;
	left: 0;
	background: #fff;
	box-shadow: 0 0px 10px 0px rgba(0, 0, 0, 0.08);
}

.header > div {
	flex: 1;
	text-align: center;
}

.header > div:nth-of-type(2) {
	flex: 3;
}

.logo img {
	position: relative;
	top: 50%;
	transform: translateY(-50%);
	height: 4rem;
	overflow: hidden;
	border-radius: 50%;
}

.header .publish .publishBtn {
	font-size: 1.5rem;
	font-weight: 700;
	color: #333;
	position: relative;
	top: 50%;
	transform: translate(0, -50%);
	background-color: rgb(230, 230, 250);
	width: 14rem;
	height: 2.8rem;
	border-radius: 3rem;
	box-shadow: 0 0 2px 1px rgba(0, 0, 0, 0.08);
}

.header .publish .publishBox {
	background-color: rgba(255, 255, 255, 0.15);
}

.header .publish .publishBox textarea {
	transform: translateY(-10%);
	border: 1px #333 solid;
	border-radius: 16px;
	box-sizing: border-box;
	padding: 15px 15px;
	font-size: 14px;
	line-height: 1.2em;
}
.header .publish .publishBox .dialog-footer {
	border: #333 1px solid;
	width: 100%;
	position: relative;
}
.header .publish .publishBox .cancel {
	position: absolute;
	left: 0;
	/* float: left; */
}

.header .publish .publishBox .confirm {
	position: absolute;
	right: 0;
}

.header .userface img {
	height: 3.5rem;
	position: relative;
	top: 50%;
	transform: translateY(-50%);
	border-radius: 3rem;
	cursor: pointer;
}
</style>