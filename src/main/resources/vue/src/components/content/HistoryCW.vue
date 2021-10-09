<template>
	<ul class="centence">
		<h2 class="title">历史文案</h2>
		<li class="CenItem" v-for="(item, index) in this.cwdataed" :key="item.cwid">
			<span>{{ index + 1 }}.{{ item.cwtext }} </span>
			<b
				class="demo-button share showof"
				@click="$toast.success('已复制到剪切板！')"
				color="success"
				><i>分享</i></b
			>
			<b
				class="demo-button deletecw showof"
				color="secondary"
				@click="confirmDelete()"
				><i>删除</i></b
			>
			<p>
				<b class="demo-button"
					>发布时间:
					{{ new Date(item.cwtime).toLocaleString().substring(0, 10) }}</b
				>
			</p>
		</li>
	</ul>
</template>

<script>
import axios from "axios";
export default {
	name: "CollectCW",
	data() {
		return {
			cwdataed: [],
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
	mounted() {
		// 获取全部历史文案
		if (!localStorage.uid) {
			this.$toast.warning("请先登录");
		} else {
			axios({
				method: "get",
				url: "/getcwbyuid",
				params: {
					uid: localStorage.uid,
				},
			})
				.then((res) => {
					console.log(res);
					this.cwdataed = res.data;
				})
				.catch((err) => {
					console.log(err);
				});
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
	font-size: 16px;
	display: block;
	padding-right: 10px;
	width: calc(100% - 10rem);
}
.CenItem > p {
	margin: 8px 0 0 10px;
	float: left;
}
.CenItem > p b {
	font-size: 13px;
	color: #aaa;
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