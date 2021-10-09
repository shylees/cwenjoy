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
				<mu-text-field v-model="notion.toNotiontext"></mu-text-field>
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
			<button
				class="confirm"
				type="primary"
				@click="$toast.success('已发布文案！')"
			>
				确 定
			</button>
		</span>
	</div>
</template>

<script>
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
};
</script>

<style socped>
@import url("../../assets/css/base.css");

.dialogBox {
	/* background-color: #fbfbfb; */
	width: 80%;
	margin: 0 auto;
}
.dialogBox div {
	background-color: #fff;
}
.dialogBox div.mu-input-line {
	background-color: rgba(0, 0, 0, 0.12);
}
.dialogBox div.mu-input-focus-line {
	background-color: rgb(51, 51, 51);
}
.mu-radio-label {
	/* width: 3.125rem; */
	/* color: #000; */
	font-size: 15px;
	text-align: left;
	margin-left: 5px;
}
</style>