var express=require('express');
var router=express.Router();
router.post('/测试.html', function (req, res, next) {
	//先查询有没有这个user
	console.log("req.body"+req.body);
	user2.findDocuments(DATABASE, "users", 1, {"uName":req.body.username}, function (user) {
		res.setHeader('Content-Type', 'application/json;charset=utf-8');
		if(user.length==0){
			//用户名没有重复 同意创建用户
			user2.insertDocuments(DATABASE, "users",
				[{
					"uName":req.body.username,
					"uPasswd":req.body.password,
					"uEmail":req.body.email,
					"uHasshop":0,
					"uShopname":"null",
					"aId":'-1'

				}],
				function (result){
					res.send({status:"success", message:"true"});
				}
			);
		}
		else{
			// 用户名重复。找到这个user 不同意创建用户
			res.send({status:"success", message:"false"});
		}
	});
});