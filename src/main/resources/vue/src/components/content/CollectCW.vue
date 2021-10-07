<template>
	<ul class="centence">
		<h2 class="title">文案收藏</h2>
		<li class="CenItem" v-for="item in this.collectdata" :key="item.cwid">
			<span>{{ item.cwtext }} </span>

			<b
				class="demo-button share showof"
				@click="$toast.success('已复制到剪切板！')"
				color="success"
				><i>分享</i></b
			>
			<b
				class="demo-button deteleCollect showof"
				color="secondary"
				@click="confirmCollected()"
				><i>取消收藏</i></b
			>
			<p>
				<b class="time">收藏时间: <br />{{ item.ctime }}</b>
			</p>
		</li>
	</ul>
</template>

<script>
export default {
	name: "CollectCW",
	data() {
		return {
			collectdata: [
				{
					cwid: "1",
					cwtext: "用绝对清醒的理智，压制不该有的情绪",
					ctime: "2021/9/10",
				},
				{
					cwid: "2",
					ctime: "2021/9/10",
					cwtext: "时间会在眨眼间流逝，顺其自然还是用尽全力？",
				},
				{
					cwid: "3",
					ctime: "2021/9/10",
					cwtext: "你对我的百般注解构成不了万分之一的我，却是一览无遗的你自己.",
				},
			],
		};
	},
	methods: {
		confirmCollected() {
			this.$confirm("确定要取消收藏？", "tip", {
				type: "warning",
			}).then(({ result }) => {
				if (result) {
					this.$toast.success("成功取消收藏！");
				} else {
					this.$toast.message("选择了取消。");
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
	border-right: 1px solid rgb(161, 115, 207);
	border-left: 1px solid rgb(161, 115, 207);
	border-top: 1px solid rgb(161, 115, 207);
	color: #444444;
	width: 100%;
	padding: 15px 15px 20px;
	margin: 0px 8px;
	text-align: left;
}
.CenItem:nth-last-of-type(1) {
	border-bottom: 1px solid rgb(161, 115, 207);
}
.CenItem span {
	font-size: 16px;
	display: block;
	padding-right: 10px;
	width: calc(100% - 10rem);
}

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
.CenItem .showof:nth-of-type(1) {
	right: 5rem;
	border-right: 1px solid #ddd;
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
</style>