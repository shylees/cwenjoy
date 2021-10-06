<template>
	<ul class="centence">
		<li class="CenItem" v-for="item in this.cwdataed" :key="item.cwid">
			<span>{{ item.cwtext }} </span>
			<p>
				<b
					class="demo-button"
					@click="$toast.success('已复制到剪切板！')"
					color="success"
					>分享</b
				>
				<b class="demo-button" color="secondary" @click="confirmDelete()"
					>删除</b
				>
				<b class="demo-button">--{{ item.cwtime }}</b>
			</p>
		</li>
	</ul>
</template>

<script>
export default {
	name: "CollectCW",
	data() {
		return {
			cwdataed: [
				{
					cwid: "1",
					cwtext: "用绝对清醒的理智，压制不该有的情绪",
					cwtime: "2021/9/10",
				},
				{
					cwid: "2",
					cwtime: "2021/9/10",
					cwtext: "时间会在眨眼间流逝，顺其自然还是用尽全力？",
				},
				{
					cwid: "3",
					cwtime: "2021/9/10",
					cwtext: "你对我的百般注解构成不了万分之一的我，却是一览无遗的你自己.",
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
	border-bottom: 1px solid rgb(161, 115, 207);
	color: #444;
	width: 100%;
	padding: 10px 15px 5px;
	margin: 4px 8px;
	text-align: left;
}
.CenItem span {
	font-size: 16px;
	display: block;
	padding-right: 20px;
}
.CenItem > p {
	float: right;
}
.CenItem > p b {
	font-size: 12px;
	color: #aaa;
	cursor: pointer;
	margin: 0 3px;
}
.CenItem > p b:hover {
	color: #000;
}
</style>