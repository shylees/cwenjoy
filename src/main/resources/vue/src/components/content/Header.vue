<template>
	<div class="header">
		<!-- logo -->
		<div class="logo">
			<img src="../../assets/logo.jpg" alt="" title="cwenjoy" />
		</div>

		<!-- public  btn 和 box -->
		<div class="publish">
			<el-button class="publishBtn" type="text" @click="ispublicBoxShow = true"
				>publish</el-button
			>

			<el-dialog
				class="publishBox dialogBox"
				:visible.sync="ispublicBoxShow"
				width="40%"
			>
				<textarea
					name="publishBoxContent"
					cols="40"
					rows="4"
					placeholder="分享你的文案吧！"
					ref="textA"
				></textarea>

				<span slot="footer" class="dialog-footer">
					<el-button class="cancel" @click="ispublicBoxShow = false"
						>取 消</el-button
					>
					<el-button
						class="confirm"
						type="primary"
						@click="ispublicBoxShow = false"
						>确 定</el-button
					>
				</span>
			</el-dialog>
		</div>

		<!-- userface   登录 注册 -->
		<div>
			<img
				class="userface"
				v-show="isLogin"
				src="../../assets/img/users/stu1.jpg"
				alt=""
				title="username"
			/>

			<p class="sign" v-show="!isLogin">
				<span class="signin" @click="issignin = true">登录</span>
				<!-- 登录 -->
				<el-dialog
					class="signinBox dialogBox"
					:visible.sync="issignin"
					width="40%"
				>
					<div class="el-dialog__header">
						<span
							class="el-dialog__title"
							style="color: rgb(94, 94, 196); font-weight: 700"
							>登 录</span
						>
					</div>
					<mu-container>
						<mu-form ref="form" :model="validateForm" class="mu-demo-form">
							<mu-form-item
								label="用户名"
								prop="username"
								:rules="usernameRules"
								align="left"
							>
								<mu-text-field
									v-model="validateForm.username"
									prop="username"
								></mu-text-field>
							</mu-form-item>
							<mu-form-item
								align="left"
								label="密码"
								prop="password"
								:rules="passwordRules"
							>
								<mu-text-field
									type="password"
									v-model="validateForm.password"
									prop="password"
								></mu-text-field>
							</mu-form-item>
						</mu-form>
					</mu-container>

					<span slot="footer" class="dialog-footer">
						<el-button class="cancel" @click="clear">取 消</el-button>
						<el-button class="confirm" @click="submit">登 录</el-button>
					</span>
				</el-dialog>

				<b>/</b>
				<span class="signup" @click="issignup = true">注册</span>
				<!-- 注册 -->
				<el-dialog
					class="signinBox dialogBox signup"
					:visible.sync="issignup"
					width="40%"
				>
					<div class="el-dialog__header">
						<span
							class="el-dialog__title"
							style="color: rgb(94, 94, 196); font-weight: 700"
							>注 册</span
						>
					</div>
					<mu-container>
						<mu-form
							:model="form"
							class="mu-demo-form"
							:label-position="labelPosition"
							label-width="100"
						>
							<mu-form-item prop="input" label="Input">
								<mu-text-field v-model="form.input"></mu-text-field>
							</mu-form-item>
							<mu-form-item prop="select" label="Select">
								<mu-select v-model="form.select">
									<mu-option
										v-for="option in options"
										:key="option"
										:label="option"
										:value="option"
									></mu-option>
								</mu-select>
							</mu-form-item>
							<mu-form-item prop="date" label="Date Time">
								<mu-date-input
									v-model="form.date"
									type="dateTime"
									actions
								></mu-date-input>
							</mu-form-item>
							<mu-form-item prop="radio" label="Radio">
								<mu-radio
									v-model="form.radio"
									value="male"
									label="Male"
								></mu-radio>
								<mu-radio
									v-model="form.radio"
									value="female"
									label="Female"
								></mu-radio>
							</mu-form-item>
							<mu-form-item prop="checkbox" label="Checkbox">
								<mu-checkbox
									v-model="form.checkbox"
									value="eat"
									label="Eat"
								></mu-checkbox>
								<mu-checkbox
									v-model="form.checkbox"
									value="sleep"
									label="Sleep"
								></mu-checkbox>
								<mu-checkbox
									v-model="form.checkbox"
									value="run"
									label="Run"
								></mu-checkbox>
								<mu-checkbox
									v-model="form.checkbox"
									value="movie"
									label="Movie"
								></mu-checkbox>
							</mu-form-item>
							<mu-form-item prop="switch" label="Switch">
								<mu-switch v-model="form.switch"></mu-switch>
							</mu-form-item>
							<mu-form-item prop="slider" label="Slider">
								<mu-slider v-model="form.slider"></mu-slider>
							</mu-form-item>
							<mu-form-item prop="textarea" label="Textarea">
								<mu-text-field
									multi-line
									:rows="3"
									:rows-max="6"
									v-model="form.textarea"
								></mu-text-field>
							</mu-form-item>
						</mu-form>
					</mu-container>
					<span slot="footer" class="dialog-footer">
						<el-button class="cancel" @click="clear">取 消</el-button>
						<el-button class="confirm" @click="submit">注 册</el-button>
					</span>
				</el-dialog>
			</p>
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
			ispublicBoxShow: false,
			isLogin: false,
			issignin: false,
			issignup: false,
			usernameRules: [
				{ validate: (val) => !!val, message: "必须填写用户名" },
				{ validate: (val) => val.length >= 3, message: "用户名长度大于3" },
			],
			passwordRules: [
				{ validate: (val) => !!val, message: "必须填写密码" },
				{
					validate: (val) => val.length >= 3 && val.length <= 10,
					message: "密码长度大于3小于10",
				},
			],
			validateForm: {
				username: "",
				password: "",
				isAgree: false,
			},
			options: ["Option 1", "Option 2"],
			labelPosition: "left",
			form: {
				input: "",
				select: "",
				date: "",
				radio: "",
				checkbox: [],
				switch: false,
				slider: 30,
				textarea: "",
			},
		};
	},
	methods: {
		submit() {
			this.$refs.form.validate().then((result) => {
				console.log("form valid: ", result);
			});
		},
		clear() {
			this.$refs.form.clear();
			this.validateForm = {
				username: "",
				password: "",
				isAgree: false,
			};
			this.issignin = false;
			this.issignup = false;
		},
	},

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
	overflow: hidden;
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

.header .dialogBox {
	background-color: rgba(255, 255, 255, 0.15);
	font-family: "Microsoft YaHei";
}

.header .publish .publishBox textarea {
	width: 60%;
	transform: translateY(-10%);
	border: 1px #333 solid;
	border-radius: 16px;
	box-sizing: border-box;
	padding: 20px;
	font-size: 0.875rem;
	line-height: 1.2em;
}
.dialogBox .el-dialog {
	margin-top: 20vh;
}
.dialogBox .el-dialog__close::before:hover {
	color: rgb(94, 94, 196);
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
.dialogBox .dialog-footer > button {
	width: 4.75rem;
	height: 1.75rem;
	position: absolute;
	line-height: 2.2em;
}

.dialogBox .cancel {
	left: 0;
	transform: translateX(0%);
}

.dialogBox .confirm {
	position: absolute;
	transform: translateX(-0%);
}

.dialogBox .dialog-footer > button:hover {
	color: #000;
	/* font-weight: 700; */
	/* background: ; */
	box-shadow: 0 0 10px 5px rgba(0, 0, 0, 0.08);
	background-color: rgb(230, 230, 250);
}

.header .userface {
	height: 3.5rem;
	position: relative;
	top: 50%;
	transform: translateY(-50%);
	border-radius: 3rem;
	cursor: pointer;
}

.header .sign {
	width: 100%;
	height: 100%;
	display: block;
	margin: 0 auto;
	line-height: 10vh;
	font-size: 17px;
}

.header .sign > b {
	font-weight: 700;
	font-size: 20px;
	color: rgb(94, 94, 196);
}
.header .sign > span {
	cursor: pointer;
	color: rgb(94, 94, 196);
}
.header .sign > span:hover {
	font-weight: 700;
}

.header .signinBox .el-dialog__body .el-dialog__header {
	height: 50px;
}
.header .signinBox div {
	background-color: #fff;
}
</style>