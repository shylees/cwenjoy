<template>
	<div class="sentencePlayground s">
		<!-- <b class="line"></b> -->
		<h2><span>文 案 广 场</span></h2>
		<div class="centences">
			<mu-container class="centencesType">
				<mu-tabs
					:value.sync="active1"
					indicator-color="transparent"
					inverse
					color="secondary"
					full-width
				>
					<mu-tab data-type="0">全部</mu-tab>
					<mu-tab data-type="1">生活文艺</mu-tab>
					<mu-tab data-type="2">阳光向上</mu-tab>
					<mu-tab data-type="3">悲观文学</mu-tab>
					<mu-tab data-type="4">听闻爱情</mu-tab>
					<mu-tab data-type="5">祝福语</mu-tab>
				</mu-tabs>
				<ul class="centence">
					<li
						class="CenItem"
						v-for="(item, index) in this.cwdata"
						:key="item.cwid"
					>
						<span>{{ index + 1 }}.{{ item.cwtext }}</span>
						<p>
							<b
								class="demo-button"
								@click="$toast.success('收藏成功！')"
								color="success"
								>收藏</b
							>
							<b
								class="demo-button"
								@click="$toast.success('已复制到剪切板！')"
								color="success"
								>分享</b
							>
							<b class="demo-button" color="secondary" @click="confirmInform()"
								>举报</b
							>
						</p>
					</li>
				</ul>
			</mu-container>
		</div>
	</div>
</template>

<script>
export default {
	name: "Centences",
	data() {
		return {
			active1: 0,
			cwdata: [
				{ cwid: "1", cwtext: "用绝对清醒的理智，压制不该有的情绪" },
				{
					cwid: "2",
					cwtext: "时间会在眨眼间流逝，顺其自然还是用尽全力？",
				},
				{
					cwid: "3",
					cwtext: "你对我的百般注解构成不了万分之一的我，却是一览无遗的你自己.",
				},
			],
		};
	},
	methods: {
		confirmInform() {
			this.$confirm("确定要举该文案？", "tip", {
				type: "warning",
			}).then(({ result }) => {
				if (result) {
					this.$toast.success("举报成功！");
				} else {
					this.$toast.message("取消举报。");
				}
			});
		},
	},
};
</script>

<style scoped>
@import "../../assets/css/base.css";
.line {
	position: relative;
	left: 50%;
	transform: translateX(-50%);
	display: block;
	border-top: 2px solid rgb(130, 67, 192);
	border-radius: 1000em/1em;
	width: 90%;
}
.s h2 {
	margin: 0 0 1em 0;
	font-size: 1.5em;
	letter-spacing: 1px;
	word-spacing: 6px;
	text-align: center;
}
.s h2 span {
	color: rebeccapurple;
	border-radius: 16px;
}
.s .centences {
	width: 85%;
	margin: 0 auto;
}
.s .centences .centencesType {
	width: 100%;
	display: flex;
	flex-wrap: wrap;
	margin: 0 auto;
	box-sizing: border-box;
}

.s .centences .centence {
	width: 100%;
	display: flex;
	flex-wrap: wrap;
	border: rebeccapurple solid 1px;
	box-sizing: border-box;
	padding: 1% 1%;
	border-radius: 8px;
}
.s .centences .CenItem {
	box-shadow: 0 0 5px 1px rgba(192, 192, 252, 0.678);
	color: #444;
	max-width: 90%;
	min-width: 40%;
	padding: 10px 15px 5px;
	margin: 10px 8px;
	text-align: left;
	border-radius: 14px;
}
.s .centences .CenItem span {
	font-size: 16px;
	display: block;
	padding-right: 20px;
	margin-bottom: 5px;
}
.s .centences .CenItem > p {
	float: right;
}
.s .centences .CenItem > p b {
	font-size: 12px;
	color: #aaa;
	cursor: pointer;
	margin: 0 3px;
}
.s .centences .CenItem > p b:hover {
	color: #000;
}

div.mu-tab,
div.mu-tab-wrapper,
div.mu-ripple-wrapper {
	border-radius: 8px;
}
div.mu-tab-active {
	background-color: rgba(192, 192, 252, 0.678);
}
.s .centence b > button {
	display: inline-block;
	background-color: none;
	width: none;
	height: none;
}
</style>