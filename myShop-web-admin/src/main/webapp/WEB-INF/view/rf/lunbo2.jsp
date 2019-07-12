<%--
  Created by IntelliJ IDEA.
  User: zhangyz
  Date: 2019/6/6
  Time: 12:46
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<header class="head">
    <a href="javascript:;" class="head-left"><i class="iconfont icon-small-arrow-left"></i></a>
    积分奖励规则
</header>

<link href="<%=request.getContextPath()%>/static/css/public.css" rel="stylesheet" type="text/css" />
<link href="<%=request.getContextPath()%>/static/css/style.css" rel="stylesheet" type="text/css" />
<link href="<%=request.getContextPath()%>/static/iconfont/iconfont.css" rel="stylesheet" type="text/css" />
<script src="<%=request.getContextPath()%>/static/js/jquery-1.8.3.min.js" language="javascript"></script>
<script src="<%=request.getContextPath()%>/static/js/flexible.js" language="javascript"></script>
<section>
    <div class="banner"><img src="<%=request.getContextPath()%>/static/images/rule-banner.png"></div>
    <h2 class="rule-h2">以下行为均可获得数额不等的积分</h2>
    <ul class="rule-box">
        <li>
            <i class="iconfont icon-kaihu"></i>
            <div class="rule-right">
                <p>开户</p>
                <p>新用户开户</p>
            </div>
        </li>
        <li>
            <i class="iconfont icon-dengluAPP"></i>
            <div class="rule-right">
                <p>登录APP</p>
                <p>登录丰收互联</p>
            </div>
        </li>
        <li>
            <i class="iconfont icon-shenghuofuwu"></i>
            <div class="rule-right">
                <p>生活服务</p>
                <p>使用学费、党费、物业费、电费、交通罚没款、服务费、电信宽带、固话等缴费服务;使用油卡，同城火车票，流量，话费等充值服务</p>
            </div>
        </li>
        <li>
            <i class="iconfont icon-zhelidai"></i>
            <div class="rule-right">
                <p>浙里贷线上首次发放</p>
                <p>浙里贷线上首次发放，且放款金额2万以上</p>
            </div>
        </li>
        <li>
            <i class="iconfont icon-saomazhifu"></i>
            <div class="rule-right">
                <p>扫码支付</p>
                <p>丰收互联扫码支付</p>
            </div>
        </li>
        <li>
            <i class="iconfont icon-shouciqianyue"></i>
            <div class="rule-right">
                <p>首次签约</p>
                <p>首次签约：e闪贷签约、定期智能存款合约、活期智能存款合约、基金定投合约、基金业务签约、理财业务签约、资金归集合约（归集账号）</p>
            </div>
        </li>
        <li>
            <i class="iconfont icon-jinrongjiaoyi"></i>
            <div class="rule-right">
                <p>金融交易类</p>
                <p>基金购买、理财购买、非税缴款、贷款借据确认、消费金融放款、信用卡还款</p>
            </div>
        </li>
    </ul>
    <p class="footer">备注：以上积分规则仅作参考，详询网点客户经理。</p>
</section>
</body>
</html>
