package com.nokchax.watcher.jsoup;

import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.util.regex.Pattern;

public class JsoupTest {
    // TODO: 2019-11-02 need simple structured html for test
    private Document document;
    private Document doc;

    @Before
    public void init() throws IOException {
        Connection connect = Jsoup.connect("https://naver.com");

        document = connect.get();
        doc = Jsoup.parse(KBD_LAB);
    }
    @Test
    public void connectTest() {
        System.out.println(document); //print whole html
        System.out.println("=====================================================");
        System.out.println(document.body()); //print body only
    }

    @Test
    public void findElementTest() {
        Elements elementsByClass = document.getElementsByClass("find by class");
        Elements elementsByTag = document.getElementsByTag("find by tag");
        Elements elementsByAttribute = document.getElementsByAttribute("find by attribute");
        // notice : by id return only one element
        Element elementById = document.getElementById("find by id");
        Elements elementsByAttributeStarting = document.getElementsByAttributeStarting("prefix key");
        Elements elementsByAttributeKeyAndValue = document.getElementsByAttributeValue("key", "value");
        Elements valueContaining = document.getElementsByAttributeValueContaining("key", "containing value");
        Elements valueEnding = document.getElementsByAttributeValueEnding("key", "ending");
        Elements valueMatchingWithRegex = document.getElementsByAttributeValueMatching("key", "regex");
        Elements valueMatchingWithPattern = document.getElementsByAttributeValueMatching("key", Pattern.compile("regex"));
        Elements valueNotMatching= document.getElementsByAttributeValueNot("key", "not matching value");
        Elements elementsByIndexEquals = document.getElementsByIndexEquals(0);
        Elements elementsByIndexGreaterThan = document.getElementsByIndexGreaterThan(0);
        Elements elementsByIndexLessThan = document.getElementsByIndexLessThan(0);
        // 자손에 포함되어 있으면 안됨??
        Elements containingOwnText = document.getElementsContainingOwnText("some text");
        Elements containingText = document.getElementsContainingText("some text");
        Elements matchingOwnText = document.getElementsMatchingOwnText("regex");
        Elements matchingOwnTextUsingPattern = document.getElementsMatchingOwnText(Pattern.compile("regex"));
        Elements matchingText = document.getElementsMatchingText("regex");
        Elements matchingTextUsingPattern = document.getElementsMatchingText(Pattern.compile("regex"));
    }

    @Test
    public void etcTest() {
        document.body();
        document.charset();
        document.head();
        document.createElement("tag name");
        //get url
        document.location();
        //????
        document.nodeName();
        document.normalise();
    }


    private static String KBD_LAB = "\n" +
            "<!DOCTYPE html>\n" +
            "<html lang=\"ko\">\n" +
            "<head>\n" +
            "<!-- META -->\n" +
            "<meta charset=\"utf-8\">\n" +
            "<meta name=\"Generator\" content=\"XpressEngine\">\n" +
            "<meta http-equiv=\"X-UA-Compatible\" content=\"IE=edge\">\n" +
            "<!-- TITLE -->\n" +
            "<title>Keyboard Lab</title>\n" +
            "<!-- CSS -->\n" +
            "<link rel=\"stylesheet\" href=\"/common/css/xe.min.css?20180607155533\" />\n" +
            "<link rel=\"stylesheet\" href=\"/common/js/plugins/ui/jquery-ui.min.css?20180607155533\" />\n" +
            "<link rel=\"stylesheet\" href=\"/layouts/xe_official/css/default.css?20120221160734\" />\n" +
            "<link rel=\"stylesheet\" href=\"/modules/editor/styles/default/style.css?20180607155539\" />\n" +
            "<link rel=\"stylesheet\" href=\"/widgets/login_info/skins/Forhanbi_login/css/forhanbi.css?20140101063514\" />\n" +
            "<link rel=\"stylesheet\" href=\"/widgets/plusadWidget/skins/default/css/default.css?20140106232725\" />\n" +
            "<link rel=\"stylesheet\" href=\"/widgets/content/skins/apprzskin/css/widget.css?20131231131512\" />\n" +
            "<link rel=\"stylesheet\" href=\"/widgets/content/skins/apprzskin/css/widgetie.css?20131231131512\" />\n" +
            "<link rel=\"stylesheet\" href=\"/widgetstyles/nico/style.css?20180729204532\" />\n" +
            "<link rel=\"stylesheet\" href=\"/widgets/content/skins/default/css/widget.css?20180607155540\" />\n" +
            "<link rel=\"stylesheet\" href=\"/widgets/attendance_check/skins/default/css/gray.css?20140106034322\" />\n" +
            "<link rel=\"stylesheet\" href=\"/files/faceOff/106/layout.css?20171221110342\" />\n" +
            "<!-- JS -->\n" +
            "<script>\n" +
            "var current_url = \"http://kbdlab.co.kr/\";\n" +
            "var request_uri = \"http://kbdlab.co.kr/\";\n" +
            "var current_mid = \"home\";\n" +
            "var waiting_message = \"서버에 요청 중입니다. 잠시만 기다려주세요.\";\n" +
            "var ssl_actions = new Array();\n" +
            "var default_url = \"http://kbdlab.co.kr/\";\n" +
            "</script>\n" +
            "<!--[if lt IE 9]><script src=\"/common/js/jquery-1.x.min.js?20180607155534\"></script>\n" +
            "<![endif]--><!--[if gte IE 9]><!--><script src=\"/common/js/jquery.min.js?20180607155534\"></script>\n" +
            "<!--<![endif]--><script src=\"/common/js/x.min.js?20180607155534\"></script>\n" +
            "<script src=\"/common/js/xe.min.js?20180607155534\"></script>\n" +
            "<script src=\"/layouts/xe_official/js/xe_official.js?20110401155130\"></script>\n" +
            "<script src=\"/widgets/login_info/skins/Forhanbi_login/js/login.js?20140101063536\"></script>\n" +
            "<script src=\"/widgets/content/skins/apprzskin/js/content_widget_min.js?20131231131523\"></script>\n" +
            "<script src=\"/widgets/content/skins/default/js/content_widget.js?20180607155540\"></script>\n" +
            "<script src=\"/widgets/attendance_check/skins/default/js/attendance.js?20140106034338\"></script>\n" +
            "<!-- RSS -->\n" +
            "<link rel=\"alternate\" type=\"application/rss+xml\" title=\"Site RSS\" href=\"/index.php?module=rss&amp;act=rss\" /><link rel=\"alternate\" type=\"application/atom+xml\" title=\"Site Atom\" href=\"/index.php?module=rss&amp;act=atom\" /><!-- ICON -->\n" +
            "\n" +
            "<script>\n" +
            "\t\t\t\t\t\tif(!captchaTargetAct) {var captchaTargetAct = [];}\n" +
            "\t\t\t\t\t\tcaptchaTargetAct.push(\"procBoardInsertDocument\",\"procBoardInsertComment\",\"procIssuetrackerInsertIssue\",\"procIssuetrackerInsertHistory\",\"procTextyleInsertComment\");\n" +
            "\t\t\t\t\t\t</script>\n" +
            "<script>\n" +
            "\t\t\t\t\t\tif(!captchaTargetAct) {var captchaTargetAct = [];}\n" +
            "\t\t\t\t\t\tcaptchaTargetAct.push(\"procMemberFindAccount\",\"procMemberResendAuthMail\",\"procMemberInsert\");\n" +
            "\t\t\t\t\t\t</script>\n" +
            "<script>\n" +
            "  (function(i,s,o,g,r,a,m){i['GoogleAnalyticsObject']=r;i[r]=i[r]||function(){\n" +
            "  (i[r].q=i[r].q||[]).push(arguments)},i[r].l=1*new Date();a=s.createElement(o),\n" +
            "  m=s.getElementsByTagName(o)[0];a.async=1;a.src=g;m.parentNode.insertBefore(a,m)\n" +
            "  })(window,document,'script','//www.google-analytics.com/analytics.js','ga');\n" +
            "\n" +
            "  ga('create', 'UA-57651056-1', 'auto');\n" +
            "  ga('send', 'pageview');\n" +
            "\n" +
            "</script>\n" +
            "<link rel=\"canonical\" href=\"http://kbdlab.co.kr/\" />\n" +
            "<meta property=\"og:locale\" content=\"ko_KR\" />\n" +
            "<meta property=\"og:type\" content=\"website\" />\n" +
            "<meta property=\"og:url\" content=\"http://kbdlab.co.kr/\" />\n" +
            "<meta property=\"og:title\" content=\"Keyboard Lab\" />\n" +
            "<style type=\"text/css\">\n" +
            "#plusad_widget{margin-left:30px;}</style><script>\n" +
            "//<![CDATA[\n" +
            "xe.current_lang = \"ko\";\n" +
            "xe.cmd_find = \"찾기\";\n" +
            "xe.cmd_cancel = \"취소\";\n" +
            "xe.cmd_confirm = \"확인\";\n" +
            "xe.msg_no_root = \"루트는 선택 할 수 없습니다.\";\n" +
            "xe.msg_no_shortcut = \"바로가기는 선택 할 수 없습니다.\";\n" +
            "xe.msg_select_menu = \"대상 메뉴 선택\";\n" +
            "//]]>\n" +
            "</script>\n" +
            "</head>\n" +
            "<body>\n" +
            "<div class=\"xe\">\n" +
            "\t<div class=\"header\">\n" +
            "\t\t<h1>\n" +
            "\t\t\t<a href=\"http://kbdlab.co.kr\"><img src=\"http://kbdlab.co.kr/files/attach/images/106/10f6298a1f8baa8150e181155613a5a8.png\" alt=\"logo\" border=\"0\" /></a>\t\t\t\t\t</h1>\n" +
            "\t\t<div class=\"language\">\n" +
            "\t\t\t<strong title=\"ko\">한국어</strong> <button type=\"button\" class=\"toggle\"><img src=\"/layouts/xe_official/images/default/buttonLang.gif\" alt=\"Select Language\" width=\"87\" height=\"15\" /></button>\n" +
            "\t\t\t<ul class=\"selectLang\">\n" +
            "\t\t\t\t\t\t\t</ul>\n" +
            "\t\t</div>\n" +
            "\t\t<div class=\"gnb\">\n" +
            "\t\t\t<ul>\n" +
            "\t\t\t\t<li class=\"active\"><a href=\"/index.php?mid=home\">KBDLAB</a>\n" +
            "\t\t\t\t\t\t\t\t</li><li><a href=\"/index.php?mid=page_UgCh80\">게시판</a>\n" +
            "\t\t\t\t<ul>\n" +
            "\t\t\t\t\t<li><a href=\"/index.php?mid=board_cUlO13\">자유 게시판</a></li><li><a href=\"/index.php?mid=board_CDST33\">묻고 답하기</a></li><li><a href=\"/index.php?mid=board_fleamarket\">키보드 장터</a></li><li><a href=\"/index.php?mid=board_pVaE30\">이벤트</a></li><li><a href=\"/index.php?mid=board_bjxK06\">공지사항</a></li><li><a href=\"/index.php?mid=board_zoSQ99\">IT 신제품 소식</a></li><li><a href=\"/index.php?mid=board_DLSF53\">키보드랩 공헌자 목록</a></li><li><a href=\"/index.php?mid=board_mOSv08\">재능나눔</a></li>\t\t\t\t</ul>\t\t\t\t</li><li><a href=\"/index.php?mid=groupbuy\">공제/공구</a>\n" +
            "\t\t\t\t<ul>\n" +
            "\t\t\t\t\t<li><a href=\"/index.php?mid=board_gb_outside\">외부 공제/공구 소식</a></li><li><a href=\"/index.php?mid=board_gb_poll\">공제 수요 조사</a></li><li><a href=\"/index.php?mid=board_groupbuy_build\">공제 토론</a></li><li><a href=\"/index.php?mid=board_gb_do\">공제 진행</a></li>\t\t\t\t</ul>\t\t\t\t</li><li><a href=\"/index.php?mid=board_Lsno50\">갤러리</a>\n" +
            "\t\t\t\t\t\t\t\t</li><li><a href=\"/index.php?mid=page_Tjjg00\">키보드 공방</a>\n" +
            "\t\t\t\t<ul>\n" +
            "\t\t\t\t\t<li><a href=\"/index.php?mid=board_YMWT22\">공지 사항</a></li><li><a href=\"/index.php?mid=board_kbdfactorys\">키보드공장장</a></li><li><a href=\"/index.php?mid=page_tMxi68\">곤방</a></li><li><a href=\"/index.php?mid=board_JkGZ32\">괴수가면</a></li><li><a href=\"/index.php?mid=board_gqHn82\">02공방</a></li><li><a href=\"/index.php?mid=page_ZpVE14\">모닝 공방</a></li><li><a href=\"/index.php?mid=board_xVbs01\">벤공방</a></li><li><a href=\"/index.php?mid=board_FMrM24\">힝힝홍힝</a></li><li><a href=\"/index.php?mid=board_ohZp47\">곰방와</a></li><li><a href=\"/index.php?mid=board_GmvX41\">NNIH 공방</a></li><li><a href=\"/index.php?mid=board_npJs25\">PORSCHE</a></li><li><a href=\"/index.php?mid=board_VvtT35\">금벌렌더</a></li><li><a href=\"/index.php?mid=board_QKCo45\">키마럽</a></li><li><a href=\"/index.php?mid=board_wfuG55\">브라이스</a></li><li><a href=\"/index.php?mid=page_FeBB27\">휴면 공방</a></li>\t\t\t\t</ul>\t\t\t\t</li><li><a href=\"/index.php?mid=data\">자료실</a>\n" +
            "\t\t\t\t<ul>\n" +
            "\t\t\t\t\t<li><a href=\"/index.php?mid=board_layout\">키배열</a></li><li><a href=\"/index.php?mid=board_housing\">하우징</a></li><li><a href=\"/index.php?mid=board_plate\">보강판</a></li><li><a href=\"/index.php?mid=board_cir\">기판</a></li><li><a href=\"/index.php?mid=board_tune\">튜닝 &amp; 조립</a></li><li><a href=\"/index.php?mid=board_sw\">키매핑 프로그램</a></li><li><a href=\"/index.php?mid=board_rXnB23\">키맵핑 파일</a></li><li><a href=\"/index.php?mid=board_keycap\">키캡</a></li><li><a href=\"/index.php?mid=board_XAIt16\">스위치</a></li><li><a href=\"/index.php?mid=board_etc\">기타</a></li>\t\t\t\t</ul>\t\t\t\t</li><li><a href=\"/index.php?mid=review\">제품 리뷰</a>\n" +
            "\t\t\t\t<ul>\n" +
            "\t\t\t\t\t<li><a href=\"/index.php?mid=board_zqlD51\">키캡</a></li><li><a href=\"/index.php?mid=board_dAHG88\">커스텀 키보드</a></li><li><a href=\"/index.php?mid=page_uvYh18\">완성품 키보드</a></li>\t\t\t\t</ul>\t\t\t\t</li><li><a href=\"/index.php?mid=park\">쉼터</a>\n" +
            "\t\t\t\t<ul>\n" +
            "\t\t\t\t\t<li><a href=\"/index.php?mid=board_twFR55\">재미있는 글/사진</a></li><li><a href=\"/index.php?mid=rockgame\">가위바위보</a></li><li><a href=\"http://kbdlab.co.kr/index.php?module=lottery\" target=\"_blank\">즉석 복권</a></li><li><a href=\"/index.php?mid=plusad\">공익 광고</a></li>\t\t\t\t</ul>\t\t\t\t</li><li><a href=\"http://kbdlab.co.kr/index.php?mid=wiki\">키보드 백과사전</a>\n" +
            "\t\t\t\t<ul>\n" +
            "\t\t\t\t\t<li><a href=\"/index.php?mid=wiki\">키보드 백과사전</a></li><li><a href=\"/index.php?mid=board_amPd18\">토론방</a></li><li><a href=\"/index.php?mid=board_QOZy36\">이미지 저장소</a></li>\t\t\t\t</ul>\t\t\t\t</li><li><a href=\"/index.php?mid=lab\">연구실</a>\n" +
            "\t\t\t\t<ul>\n" +
            "\t\t\t\t\t<li><a href=\"/index.php?mid=board_bvJm72\">키 레이아웃 연구실</a></li><li><a href=\"/index.php?mid=board_raQz47\">키캡 디자인 연구실</a></li><li><a href=\"/index.php?mid=board_nsyk48\">하우징 디자인 연구실</a></li>\t\t\t\t</ul>\t\t\t\t</li>\t\t\t</ul>\n" +
            "\t\t</div>\n" +
            "\t\t<form action=\"http://kbdlab.co.kr/\" method=\"post\" class=\"iSearch\"><input type=\"hidden\" name=\"error_return_url\" value=\"/\" />\n" +
            "\t\t\t\t\t\t<input type=\"hidden\" name=\"mid\" value=\"home\" />\n" +
            "\t\t\t<input type=\"hidden\" name=\"act\" value=\"IS\" />\n" +
            "\t\t\t<input type=\"hidden\" name=\"search_target\" value=\"title_content\" />\n" +
            "\t\t\t<input name=\"is_keyword\" type=\"text\" class=\"iText\" title=\"keyword\" />\n" +
            "\t\t\t<input type=\"image\" src=\"/layouts/xe_official/images/default/buttonSearch.gif\" alt=\"검색\" class=\"submit\" />\n" +
            "\t\t</form>\n" +
            "\t</div>\n" +
            "\t<div class=\"body\">\n" +
            "\t\t<div class=\"lnb\">\n" +
            "\t\t\t<div class=\"xe-widget-wrapper \" style=\"\"><div style=\"*zoom:1;padding:0px 0px 0px 0px !important;\"><div class=\"wrap-forhanbi-login\">\n" +
            "\t<div class=\"login_top\"><span class=\"TL-F-L\"></span><span class=\"TR-F-L\"></span></div>\n" +
            "\t\t<div class=\"login_middle\" class=\"loginFormA\">\n" +
            "\t\t\t<div id=\"login_box\" class=\"loginForm\">\n" +
            "\t\t\t\t\t\t\t\t\t<form id=\"fo_login_widget\" action=\"./\" method=\"post\" ruleset=\"@login\" class=\"login_forhanbi\">\n" +
            "\t\t\t\t\t\t\t\t\t<fieldset>\n" +
            "\t\t\t\t\t\t<legend>로그인</legend>\n" +
            "\t\t\t\t\t\t<input type=\"hidden\" name=\"act\" value=\"procMemberLogin\" />\n" +
            "\t\t\t\t\t\t<input type=\"hidden\" name=\"success_return_url\" value=\"/\" />\n" +
            "\t\t\t\t\t\t<div class=\"idpwWrap\">\n" +
            "\t\t\t\t\t\t\t<div class=\"idpw\">\n" +
            "\t\t\t\t\t\t\t\t<input name=\"user_id\" type=\"text\" title=\"user id\" />\n" +
            "\t\t\t\t\t\t\t\t<input name=\"password\" type=\"password\" title=\"password\" />\n" +
            "\t\t\t\t\t\t\t</div>\n" +
            "\t\t\t\t\t\t\t<div class=\"imglogin\"><input type=\"image\" src=\"/widgets/login_info/skins/Forhanbi_login/img/buttonLogin.gif\" alt=\"login\" class=\"login\" /></div>\n" +
            "\t\t\t\t\t\t</div>\n" +
            "\t\t\t\t\t\t\t\t\t\t\t\t <p class=\"keep\">\n" +
            "\t\t\t\t\t\t\t<input type=\"checkbox\" name=\"keep_signed\" id=\"keep_signed\" value=\"Y\" />\n" +
            "\t\t\t\t\t\t\t<label for=\"keep_signed\">로그인 유지</label>\n" +
            "\t\t\t\t\t\t</p>\n" +
            "\t\t\t\t\t\t<p class=\"keep_msg\">브라우저를 닫더라도 로그인이 계속 유지될 수 있습니다. 로그인 유지 기능을 사용할 경우 다음 접속부터는 로그인할 필요가 없습니다. 단, 게임방, 학교 등 공공장소에서 이용 시 개인정보가 유출될 수 있으니 꼭 로그아웃을 해주세요.</p>\n" +
            "\t\t\t\t\t\t<ul class=\"help\">\n" +
            "\t\t\t\t\t\t\t<li class=\"sign\"><a href=\"/index.php?mid=home&amp;act=dispMemberSignUpForm\">회원가입</a></li>\n" +
            "\t\t\t\t\t\t\t<li class=\"account\"><a href=\"/index.php?mid=home&amp;act=dispMemberFindAccount\">ID/PW 찾기</a></li>\n" +
            "\t\t\t\t\t\t\t<li class=\"mail\"><a href=\"/index.php?mid=home&amp;act=dispMemberResendAuthMail\">인증메일 재발송</a></li>\n" +
            "\t\t\t\t\t\t</ul>\n" +
            "\t\t\t\t\t</fieldset>\n" +
            "\t\t\t\t</form>\n" +
            "\t\t\t</div>\n" +
            "\t\t</div>\n" +
            "\t<div class=\"login_bottom\"><span class=\"BL-F-L\"></span><span class=\"BR-F-L\"></span></div>\n" +
            "</div>\n" +
            "</div></div>\n" +
            "\t\t\t<h2><a href=\"/index.php?mid=home\">KBDLAB</a></h2>\t\t\t\t\t\t<!-- 채팅창 시작 -->\n" +
            "                        <div class=\"xe-widget-wrapper \" style=\"\"><div style=\"*zoom:1;padding:0px 0px 0px 0px !important;\"><div style=\"width:100;height:550px;overflow:hidden;\">\n" +
            "\t<script async src=\"//client.uchat.io/uchat.js\" charset=\"utf-8\"></script>\n" +
            "\t<u-chat room='kbdlab' user_data='room kbdlab|time 1572872933|hash efb115c7687f9c919fc906c5f7b5d6b6' style=\"display:inline-block; width:100%; height:100%;\"></u-chat>\n" +
            "</div></div></div> \n" +
            "                        <!--    \n" +
            "                        <div class=\"xe-widget-wrapper \" style=\"\"><div style=\"*zoom:1;padding:0px 0px 0px 0px !important;\"><script type=\"text/javascript\" src=\"//uchat.co.kr/uchat.php\" charset=\"UTF-8\"></script>\n" +
            "<script type=\"text/javascript\">\n" +
            "u_chat({\n" +
            "\troom:\"kbdlab\"\n" +
            "\t, width:100\t, height:450\t\t, md5:\"5915585a119b888e0c3fe00d8c782580\"\n" +
            "\t, nick:\"\"\n" +
            "\t, mb_id:\"\"\n" +
            "\t, level:\"\"\n" +
            "\t, icon:\"\"\n" +
            "\t, nickcon:\"\"\n" +
            "\t\t, no_inout:true\t, chat_record:true\t, skin:1\t});\n" +
            "</script></div></div>   \n" +
            "                        -->\n" +
            "\t\t\t<!-- 채팅창 종료-->\n" +
            "                        <br/><br/>\n" +
            "\t\t\t<!-- 광고 시작 -->        \n" +
            "\t\t\t<div class=\"xe-widget-wrapper \" style=\"\"><div style=\"*zoom:1;padding:0px 0px 0px 0px !important;\"> \n" +
            "\t<div id=\"plusad_widget_wrap\">\n" +
            "\t<div class=\"plusad_point\"><a href=\"/index.php?mid=plusad&amp;act=dispPlusadlist\" title=\"광고를 등록하세요\">AD</a></div>\t<ul id=\"plusad_widget\">\t\n" +
            "\t\t\t\t\t<li>\n" +
            "\t\t\t\t<a style=\"font-weight:bold; color:red;\" href=\"/index.php?mid=plusad&amp;act=dispPlusadlist\">진행중인 광고가 없습니다. 광고를 등록해주세요</a>\n" +
            "\t\t\t</li>\n" +
            "\t\t\t\t \n" +
            "\t\t\t</ul>\n" +
            "</div>\n" +
            " \n" +
            "<script type=\"text/javascript\">\n" +
            "jQuery(function($){\n" +
            "\t\n" +
            "\t//함수 호출\n" +
            "\t$(function(){\n" +
            "\t\t\n" +
            "\t\t//마우스 오버시 중지\n" +
            "\t\tmove_stop = 1; //변수생성\n" +
            "\t\t$('#plusad_widget_wrap').mouseenter(function(){\n" +
            "\t\t\tmove_stop = 0; //오버시 중지\n" +
            "\t\t}).mouseleave(function(){\n" +
            "\t\t\tmove_stop = 1; \n" +
            "\t\t});\n" +
            "\t\t\n" +
            "\t\tvar ad_length = $('#plusad_widget li').size(); //광고 목록수 구함\n" +
            "\t\tif( ad_length > 1){ //목록 1개이상일때 롤링함수 호출\n" +
            "\t\t\tplusad_roll(100,60000,25,0);\n" +
            "\t\t}\t\n" +
            "\t});\n" +
            "\t\n" +
            "\t\n" +
            "\t//롤링함수\n" +
            "\tfunction plusad_roll(speed, delay, ad_height, this_height){ //롤링속도, 롤링간격, 배너높이, 현재높이\n" +
            "\t\t\n" +
            "\t\tvar ad = $('#plusad_widget');\n" +
            "\t\tvar ad_list = $('#plusad_widget li:first');\n" +
            "\t\t\n" +
            "\t\t\n" +
            "\t\tif(move_stop) this_height++; //마우스 오버시 중지\n" +
            "\t\t\n" +
            "\t\tif(this_height <= ad_height){\n" +
            "\t\t\t\n" +
            "\t\t\t//스크롤함\n" +
            "\t\t\t$(ad).css('top',-this_height);\n" +
            "\t\t\t\n" +
            "\t\t\t//함수호출 (스크롤)\n" +
            "\t\t\tsetTimeout(function(){\n" +
            "\t\t\t\tplusad_roll(speed, delay, ad_height, this_height);\n" +
            "\t\t\t},speed);\n" +
            "\t\t}else{\n" +
            "\t\t\n" +
            "\t\t\t//스크롤된 리스트 맨뒤로 이동\n" +
            "\t\t\t$(ad_list).appendTo($(ad));\n" +
            "\t\t\t$(ad).css('top',0);\n" +
            "\t\t\t\n" +
            "\t\t\t//함수호출 (롤링)\n" +
            "\t\t\tsetTimeout(function(){\n" +
            "\t\t\t\tplusad_roll(speed, delay, ad_height, 0);\n" +
            "\t\t\t},delay);\n" +
            "\t\t\t\n" +
            "\t\t}\n" +
            "\t}\n" +
            "\t\n" +
            "});\n" +
            "</script>\n" +
            "</div></div>\n" +
            "\t\t\t<!-- 광고 종료-->\n" +
            "\t\t\t<!-- 좌측 메뉴에 배너 추가 시작 -->\n" +
            "\t\t\t<br/><br/><br/>\n" +
            "\t\t\t<div class=\"quickBanner\">\n" +
            "\t\t\t\t<center>\n" +
            "\t\t\t\t\t<!-- 메세지는 이곳에 추가 -->\n" +
            "\t\t\t\t\t\n" +
            "\t\t\t\t\t</a>\n" +
            "\t\t\t\t</center>\n" +
            "\t\t\t</div>\n" +
            "\t\t\t<!-- 좌측 메뉴에 배너 추가 끝 -->\n" +
            "\t\t</div>\n" +
            "\t\t<div class=\"content xe_content\">\n" +
            "\t\t\t<div class=\"xe-widget-wrapper \" style=\"width: 100%; float: left;\"><div style=\"*zoom:1;padding:0px 0px 0px 0px !important;\"><div class=\"apzwidgetContainer\">\n" +
            "        <ul class=\"apzwidgetGalleryA\" style=\"width:699px;\">\n" +
            "        <li style=\"width:223px;\">\n" +
            "                                \t\n" +
            "            \t<div class=\"tmb_wrp\">\n" +
            "                <a href=\"/index.php?mid=board_Lsno50&amp;document_srl=5973871\" class=\"thumb\" style=\"width:223px;height:180px\">\n" +
            "                                            <img class=\"tmb\" src=\"http://kbdlab.co.kr/files/thumbnails/871/973/005/223x180.crop.jpg\" style=\"width:223px;height:180px\"/ width=\"223\" height=\"180\">\n" +
            "                                                    \t\n" +
            "                                \t<div class=\"view\">\n" +
            "                \t\t \n" +
            "                \t</div>\n" +
            "                \t\n" +
            "                </a>\n" +
            "            \t</div>\n" +
            "            \n" +
            "                     \n" +
            "                    \n" +
            "            <div class=\"heading\" style=\"width:193px;\">        \n" +
            "                  <p class=\"meta\">\n" +
            "                     \n" +
            "\t\t           \n" +
            "                                       </br> <span><a href=\"/index.php?mid=board_Lsno50&amp;document_srl=5973871#comment\">5 Comments</a></span>\n" +
            "                                    \n" +
            "                                    \t <span><a href=\"#\" onclick=\"return false;\" style=\"color:#fff\" class=\"author member_5042327\"><img src=\"http://kbdlab.co.kr/modules/point/icons/kbdlab/13.gif\" alt=\"[레벨:13]\" title=\"포인트:13125point (68%), 레벨:13/100\" class=\"xe_point_level_icon\" style=\"vertical-align:middle;margin-right:3px;\" />2nvoi</a></span>\n" +
            "                  \t\t\n" +
            "                  </p>\n" +
            "                     \n" +
            "                  <h2><a href=\"/index.php?mid=board_Lsno50&amp;document_srl=5973871\">또가스</a></h2>\n" +
            "                  \n" +
            "                                    \t                  \t<span class=\"ribbon\"></span>\n" +
            "                  \t                    \n" +
            "            </div>\n" +
            "                        \n" +
            "                     \n" +
            "                            \t\t\n" +
            "                     \n" +
            "              \n" +
            "    </li>\n" +
            "            <li style=\"width:223px;\">\n" +
            "                                \t\n" +
            "            \t<div class=\"tmb_wrp\">\n" +
            "                <a href=\"/index.php?mid=board_Lsno50&amp;document_srl=5973632\" class=\"thumb\" style=\"width:223px;height:180px\">\n" +
            "                                            <img class=\"tmb\" src=\"http://kbdlab.co.kr/files/thumbnails/632/973/005/223x180.crop.jpg\" style=\"width:223px;height:180px\"/ width=\"223\" height=\"180\">\n" +
            "                                                    \t\n" +
            "                                \t<div class=\"view\">\n" +
            "                \t\t \n" +
            "                \t</div>\n" +
            "                \t\n" +
            "                </a>\n" +
            "            \t</div>\n" +
            "            \n" +
            "                     \n" +
            "                    \n" +
            "            <div class=\"heading\" style=\"width:193px;\">        \n" +
            "                  <p class=\"meta\">\n" +
            "                     \n" +
            "\t\t           \n" +
            "                                       </br> <span><a href=\"/index.php?mid=board_Lsno50&amp;document_srl=5973632#comment\">38 Comments</a></span>\n" +
            "                                    \n" +
            "                                    \t <span><a href=\"#\" onclick=\"return false;\" style=\"color:#fff\" class=\"author member_5007294\"><img src=\"http://kbdlab.co.kr/modules/point/icons/kbdlab/21.gif\" alt=\"[레벨:21]\" title=\"포인트:30978point (3%), 레벨:21/100\" class=\"xe_point_level_icon\" style=\"vertical-align:middle;margin-right:3px;\" />RookyBomb</a></span>\n" +
            "                  \t\t\n" +
            "                  </p>\n" +
            "                     \n" +
            "                  <h2><a href=\"/index.php?mid=board_Lsno50&amp;document_srl=5973632\">덕 라인 무게추</a></h2>\n" +
            "                  \n" +
            "                                    \t                  \t<span class=\"ribbon\"></span>\n" +
            "                  \t                    \n" +
            "            </div>\n" +
            "                        \n" +
            "                     \n" +
            "                            \t\t\n" +
            "                     \n" +
            "              \n" +
            "    </li>\n" +
            "            <li style=\"width:223px;\">\n" +
            "                                \t\n" +
            "            \t<div class=\"tmb_wrp\">\n" +
            "                <a href=\"/index.php?mid=board_Lsno50&amp;document_srl=5973274\" class=\"thumb\" style=\"width:223px;height:180px\">\n" +
            "                                            <img class=\"tmb\" src=\"http://kbdlab.co.kr/files/thumbnails/274/973/005/223x180.crop.jpg\" style=\"width:223px;height:180px\"/ width=\"223\" height=\"180\">\n" +
            "                                                    \t\n" +
            "                                \t<div class=\"view\">\n" +
            "                \t\t \n" +
            "                \t</div>\n" +
            "                \t\n" +
            "                </a>\n" +
            "            \t</div>\n" +
            "            \n" +
            "                     \n" +
            "                    \n" +
            "            <div class=\"heading\" style=\"width:193px;\">        \n" +
            "                  <p class=\"meta\">\n" +
            "                     \n" +
            "\t\t           \n" +
            "                                       </br> <span><a href=\"/index.php?mid=board_Lsno50&amp;document_srl=5973274#comment\">9 Comments</a></span>\n" +
            "                                    \n" +
            "                                    \t <span><a href=\"#\" onclick=\"return false;\" style=\"color:#fff\" class=\"author member_217103\"><img src=\"http://kbdlab.co.kr/modules/point/icons/kbdlab/16.gif\" alt=\"[레벨:16]\" title=\"포인트:18304point (16%), 레벨:16/100\" class=\"xe_point_level_icon\" style=\"vertical-align:middle;margin-right:3px;\" />신의손가락</a></span>\n" +
            "                  \t\t\n" +
            "                  </p>\n" +
            "                     \n" +
            "                  <h2><a href=\"/index.php?mid=board_Lsno50&amp;document_srl=5973274\">게임 전시용 키보드</a></h2>\n" +
            "                  \n" +
            "                                    \t                  \t<span class=\"ribbon\"></span>\n" +
            "                  \t                    \n" +
            "            </div>\n" +
            "                        \n" +
            "                     \n" +
            "                            \t\t\n" +
            "                     \n" +
            "              \n" +
            "    </li>\n" +
            "            <li class=\"clearLeft\" style=\"width:223px;\">\n" +
            "                                \t\n" +
            "            \t<div class=\"tmb_wrp\">\n" +
            "                <a href=\"/index.php?mid=board_Lsno50&amp;document_srl=5973160\" class=\"thumb\" style=\"width:223px;height:180px\">\n" +
            "                                            <img class=\"tmb\" src=\"http://kbdlab.co.kr/files/thumbnails/160/973/005/223x180.crop.jpg\" style=\"width:223px;height:180px\"/ width=\"223\" height=\"180\">\n" +
            "                                                    \t\n" +
            "                                \t<div class=\"view\">\n" +
            "                \t\t \n" +
            "                \t</div>\n" +
            "                \t\n" +
            "                </a>\n" +
            "            \t</div>\n" +
            "            \n" +
            "                     \n" +
            "                    \n" +
            "            <div class=\"heading\" style=\"width:193px;\">        \n" +
            "                  <p class=\"meta\">\n" +
            "                     \n" +
            "\t\t           \n" +
            "                                       </br> <span><a href=\"/index.php?mid=board_Lsno50&amp;document_srl=5973160#comment\">7 Comments</a></span>\n" +
            "                                    \n" +
            "                                    \t <span><a href=\"#\" onclick=\"return false;\" style=\"color:#fff\" class=\"author member_3770496\"><img src=\"http://kbdlab.co.kr/modules/point/icons/kbdlab/20.gif\" alt=\"[레벨:20]\" title=\"포인트:29873point (65%), 레벨:20/100\" class=\"xe_point_level_icon\" style=\"vertical-align:middle;margin-right:3px;\" />흐데엉리</a></span>\n" +
            "                  \t\t\n" +
            "                  </p>\n" +
            "                     \n" +
            "                  <h2><a href=\"/index.php?mid=board_Lsno50&amp;document_srl=5973160\">아크릴 세트 구성했습니다</a></h2>\n" +
            "                  \n" +
            "                                    \t                  \t<span class=\"ribbon\"></span>\n" +
            "                  \t                    \n" +
            "            </div>\n" +
            "                        \n" +
            "                     \n" +
            "                            \t\t\n" +
            "                     \n" +
            "              \n" +
            "    </li>\n" +
            "            <li style=\"width:223px;\">\n" +
            "                                \t\n" +
            "            \t<div class=\"tmb_wrp\">\n" +
            "                <a href=\"/index.php?mid=board_Lsno50&amp;document_srl=5972648\" class=\"thumb\" style=\"width:223px;height:180px\">\n" +
            "                                            <img class=\"tmb\" src=\"http://kbdlab.co.kr/files/thumbnails/648/972/005/223x180.crop.jpg\" style=\"width:223px;height:180px\"/ width=\"223\" height=\"180\">\n" +
            "                                                    \t\n" +
            "                                \t<div class=\"view\">\n" +
            "                \t\t \n" +
            "                \t</div>\n" +
            "                \t\n" +
            "                </a>\n" +
            "            \t</div>\n" +
            "            \n" +
            "                     \n" +
            "                    \n" +
            "            <div class=\"heading\" style=\"width:193px;\">        \n" +
            "                  <p class=\"meta\">\n" +
            "                     \n" +
            "\t\t           \n" +
            "                                       </br> <span><a href=\"/index.php?mid=board_Lsno50&amp;document_srl=5972648#comment\">12 Comments</a></span>\n" +
            "                                    \n" +
            "                                    \t <span><a href=\"#\" onclick=\"return false;\" style=\"color:#fff\" class=\"author member_4096259\"><img src=\"http://kbdlab.co.kr/modules/point/icons/kbdlab/15.gif\" alt=\"[레벨:15]\" title=\"포인트:17753point (92%), 레벨:15/100\" class=\"xe_point_level_icon\" style=\"vertical-align:middle;margin-right:3px;\" />잔당</a></span>\n" +
            "                  \t\t\n" +
            "                  </p>\n" +
            "                     \n" +
            "                  <h2><a href=\"/index.php?mid=board_Lsno50&amp;document_srl=5972648\">Lz stan</a></h2>\n" +
            "                  \n" +
            "                                    \t                    \n" +
            "            </div>\n" +
            "                        \n" +
            "                     \n" +
            "                            \t\t\n" +
            "                     \n" +
            "              \n" +
            "    </li>\n" +
            "            <li style=\"width:223px;\">\n" +
            "                                \t\n" +
            "            \t<div class=\"tmb_wrp\">\n" +
            "                <a href=\"/index.php?mid=board_Lsno50&amp;document_srl=5972362\" class=\"thumb\" style=\"width:223px;height:180px\">\n" +
            "                                            <img class=\"tmb\" src=\"http://kbdlab.co.kr/files/thumbnails/362/972/005/223x180.crop.jpg\" style=\"width:223px;height:180px\"/ width=\"223\" height=\"180\">\n" +
            "                                                    \t\n" +
            "                                \t<div class=\"view\">\n" +
            "                \t\t \n" +
            "                \t</div>\n" +
            "                \t\n" +
            "                </a>\n" +
            "            \t</div>\n" +
            "            \n" +
            "                     \n" +
            "                    \n" +
            "            <div class=\"heading\" style=\"width:193px;\">        \n" +
            "                  <p class=\"meta\">\n" +
            "                     \n" +
            "\t\t           \n" +
            "                                       </br> <span><a href=\"/index.php?mid=board_Lsno50&amp;document_srl=5972362#comment\">10 Comments</a></span>\n" +
            "                                    \n" +
            "                                    \t <span><a href=\"#\" onclick=\"return false;\" style=\"color:#fff\" class=\"author member_2992\"><img src=\"http://kbdlab.co.kr/modules/point/icons/kbdlab/100.gif\" alt=\"[레벨:100]\" title=\"포인트:100125499point, 레벨:100/100\" class=\"xe_point_level_icon\" style=\"vertical-align:middle;margin-right:3px;\" />아침에™⇔N²</a></span>\n" +
            "                  \t\t\n" +
            "                  </p>\n" +
            "                     \n" +
            "                  <h2><a href=\"/index.php?mid=board_Lsno50&amp;document_srl=5972362\">제트스톰</a></h2>\n" +
            "                  \n" +
            "                                    \t                    \n" +
            "            </div>\n" +
            "                        \n" +
            "                     \n" +
            "                            \t\t\n" +
            "                     \n" +
            "              \n" +
            "    </li>\n" +
            "        </ul>\n" +
            "</div>\n" +
            "</div></div><div class=\"xe_content xe-widget-wrapper \" style=\"width: 100%; float: left;\"><div style=\"padding:0px 0px 0px 0px !important;\"><b><p><b></b></p>\n" +
            "<p><br /></p>\n" +
            "<p><br /></p>\n" +
            "</b></div></div><div class=\"xe-widget-wrapper \" style=\"width: 100%; float: left;\"><div class=\"ws_nico\">\n" +
            "  <div class=\"css3pie ws_nico_title\" style=\"\">\n" +
            "          <a href=\"http://kbdlab.co.kr/data\">\n" +
            "              자료실            </a>\n" +
            "        <div class=\"ws_nico_arrow_border\"></div>\n" +
            "    <div class=\"ws_nico_arrow_bg\" ></div>\n" +
            "  </div>\n" +
            "  <div class=\"ws_nico_content\">\n" +
            "    <div style=\"*zoom:1;padding:0px 0px 0px 0px !important;\"><div class=\"widgetContainer\">\n" +
            "                    <table class=\"widgetTableA\" border=\"1\" cellspacing=\"0\">\n" +
            "        <tbody>\n" +
            "                <tr>\n" +
            "                <td class=\"title\">\n" +
            "                    \n" +
            "                <a href=\"http://kbdlab.co.kr/index.php?mid=board_sw\"><strong class=\"board\">키매핑 프로그램</strong></a>\n" +
            "                                    <a href=\"/index.php?mid=board_sw&amp;document_srl=5974050\">C³-LDN RGB80% PCB 관련 프로그램</a>\n" +
            "                            <em class=\"replyNum\" title=\"Replies\"><a href=\"/index.php?mid=board_sw&amp;document_srl=5974050#comment\">4</a></em>\n" +
            "                                                    <span class=\"icon\"><img src=\"http://kbdlab.co.kr/modules/document/tpl/icons//new.gif\" alt=\"new\" title=\"new\" style=\"margin-right:2px;\" /><img src=\"http://kbdlab.co.kr/modules/document/tpl/icons//file.gif\" alt=\"file\" title=\"file\" style=\"margin-right:2px;\" /></span>\n" +
            "                    </td>\n" +
            "                    <td class=\"time\"><span class=\"date\">2019-11-04</span> <span class=\"hour\">17:29</span></td>\n" +
            "                    <td><a href=\"#\" onclick=\"return false;\" class=\"author member_409598\" ><img src=\"http://kbdlab.co.kr/modules/point/icons/kbdlab/39.gif\" alt=\"[레벨:39]\" title=\"포인트:109213point (49%), 레벨:39/100\" class=\"xe_point_level_icon\" style=\"vertical-align:middle;margin-right:3px;\" />Gomzip</a></td>\n" +
            "                </tr>\n" +
            "                <tr>\n" +
            "                <td class=\"title\">\n" +
            "                    \n" +
            "                <a href=\"http://kbdlab.co.kr/index.php?mid=board_housing\"><strong class=\"board\">하우징</strong></a>\n" +
            "                                    <a href=\"/index.php?mid=board_housing&amp;document_srl=5966336\">젝스톰 아크릴 하우징(19.10.30 수정)</a>\n" +
            "                            <em class=\"replyNum\" title=\"Replies\"><a href=\"/index.php?mid=board_housing&amp;document_srl=5966336#comment\">2</a></em>\n" +
            "                                                    <span class=\"icon\"><img src=\"http://kbdlab.co.kr/modules/document/tpl/icons//file.gif\" alt=\"file\" title=\"file\" style=\"margin-right:2px;\" /></span>\n" +
            "                    </td>\n" +
            "                    <td class=\"time\"><span class=\"date\">2019-10-28</span> <span class=\"hour\">20:54</span></td>\n" +
            "                    <td><a href=\"#\" onclick=\"return false;\" class=\"author member_409598\" ><img src=\"http://kbdlab.co.kr/modules/point/icons/kbdlab/39.gif\" alt=\"[레벨:39]\" title=\"포인트:109213point (49%), 레벨:39/100\" class=\"xe_point_level_icon\" style=\"vertical-align:middle;margin-right:3px;\" />Gomzip</a></td>\n" +
            "                </tr>\n" +
            "                <tr>\n" +
            "                <td class=\"title\">\n" +
            "                    \n" +
            "                <a href=\"http://kbdlab.co.kr/index.php?mid=board_housing\"><strong class=\"board\">하우징</strong></a>\n" +
            "                                    <a href=\"/index.php?mid=board_housing&amp;document_srl=5966190\">제트스톰 아크릴 하우징 팜레</a>\n" +
            "                                                    <span class=\"icon\"><img src=\"http://kbdlab.co.kr/modules/document/tpl/icons//file.gif\" alt=\"file\" title=\"file\" style=\"margin-right:2px;\" /></span>\n" +
            "                    </td>\n" +
            "                    <td class=\"time\"><span class=\"date\">2019-10-28</span> <span class=\"hour\">17:52</span></td>\n" +
            "                    <td><a href=\"#\" onclick=\"return false;\" class=\"author member_2992\" ><img src=\"http://kbdlab.co.kr/modules/point/icons/kbdlab/100.gif\" alt=\"[레벨:100]\" title=\"포인트:100125499point, 레벨:100/100\" class=\"xe_point_level_icon\" style=\"vertical-align:middle;margin-right:3px;\" />아침에™⇔N²</a></td>\n" +
            "                </tr>\n" +
            "                <tr>\n" +
            "                <td class=\"title\">\n" +
            "                    \n" +
            "                <a href=\"http://kbdlab.co.kr/index.php?mid=board_housing\"><strong class=\"board\">하우징</strong></a>\n" +
            "                                    <a href=\"/index.php?mid=board_housing&amp;document_srl=5963803\">제트스톰 아크릴 하우징</a>\n" +
            "                                                    <span class=\"icon\"><img src=\"http://kbdlab.co.kr/modules/document/tpl/icons//file.gif\" alt=\"file\" title=\"file\" style=\"margin-right:2px;\" /></span>\n" +
            "                    </td>\n" +
            "                    <td class=\"time\"><span class=\"date\">2019-10-26</span> <span class=\"hour\">19:00</span></td>\n" +
            "                    <td><a href=\"#\" onclick=\"return false;\" class=\"author member_2992\" ><img src=\"http://kbdlab.co.kr/modules/point/icons/kbdlab/100.gif\" alt=\"[레벨:100]\" title=\"포인트:100125499point, 레벨:100/100\" class=\"xe_point_level_icon\" style=\"vertical-align:middle;margin-right:3px;\" />아침에™⇔N²</a></td>\n" +
            "                </tr>\n" +
            "                <tr>\n" +
            "                <td class=\"title\">\n" +
            "                    \n" +
            "                <a href=\"http://kbdlab.co.kr/index.php?mid=board_housing\"><strong class=\"board\">하우징</strong></a>\n" +
            "                                    <a href=\"/index.php?mid=board_housing&amp;document_srl=5961639\">젯스톰 하우징 오픈 도면입니다.</a>\n" +
            "                                                    <span class=\"icon\"><img src=\"http://kbdlab.co.kr/modules/document/tpl/icons//file.gif\" alt=\"file\" title=\"file\" style=\"margin-right:2px;\" /></span>\n" +
            "                    </td>\n" +
            "                    <td class=\"time\"><span class=\"date\">2019-10-24</span> <span class=\"hour\">15:02</span></td>\n" +
            "                    <td><a href=\"#\" onclick=\"return false;\" class=\"author member_238436\" ><img src=\"http://kbdlab.co.kr/modules/point/icons/kbdlab/44.gif\" alt=\"[레벨:44]\" title=\"포인트:141020point (88%), 레벨:44/100\" class=\"xe_point_level_icon\" style=\"vertical-align:middle;margin-right:3px;\" />.benkei.</a></td>\n" +
            "                </tr>\n" +
            "                </tbody>\n" +
            "    </table>\n" +
            "        </div>\n" +
            "</div>  </div>\n" +
            "</div>\n" +
            "</div><div class=\"xe_content xe-widget-wrapper \" style=\"width: 100%; float: left;\"><div style=\"padding:0px 0px 0px 0px !important;\"><b>\n" +
            "<p><br /></p>\n" +
            "<p><br /></p>\n" +
            "\n" +
            "</b></div></div><div class=\"xe-widget-wrapper \" style=\"margin: 0px 10px 0px 0px; border: 0px solid rgb(255, 255, 255); width: 360px; float: left; background-image: none; background-repeat: repeat; background-color: rgb(255, 255, 255);\"><div class=\"ws_nico\">\n" +
            "  <div class=\"css3pie ws_nico_title\" style=\"\">\n" +
            "          <a href=\"http://kbdlab.co.kr/board_cUlO13\">\n" +
            "              게시판            </a>\n" +
            "        <div class=\"ws_nico_arrow_border\"></div>\n" +
            "    <div class=\"ws_nico_arrow_bg\" ></div>\n" +
            "  </div>\n" +
            "  <div class=\"ws_nico_content ws_nico_border\">\n" +
            "    <div style=\"*zoom:1;padding:0px 0px 0px 0px !important;\"><div class=\"widgetContainer\">\n" +
            "                    <table class=\"widgetTableA\" border=\"1\" cellspacing=\"0\">\n" +
            "        <tbody>\n" +
            "                <tr>\n" +
            "                <td class=\"title\">\n" +
            "                                    <a href=\"/index.php?mid=board_pVaE30&amp;document_srl=5974073\">스위치필름, 스테빌, 흡음재(?) 나눔합니다..</a>\n" +
            "                            <em class=\"replyNum\" title=\"Replies\"><a href=\"/index.php?mid=board_pVaE30&amp;document_srl=5974073#comment\">4</a></em>\n" +
            "                                                    <span class=\"icon\"><img src=\"http://kbdlab.co.kr/modules/document/tpl/icons//new.gif\" alt=\"new\" title=\"new\" style=\"margin-right:2px;\" /><img src=\"http://kbdlab.co.kr/modules/document/tpl/icons//file.gif\" alt=\"file\" title=\"file\" style=\"margin-right:2px;\" /></span>\n" +
            "                    </td>\n" +
            "                </tr>\n" +
            "                <tr>\n" +
            "                <td class=\"title\">\n" +
            "                                    <a href=\"/index.php?mid=board_cUlO13&amp;document_srl=5972502\">스텝스 컬쳐가 아니라 스텝 스컵쳐가 맞는 것 같은데</a>\n" +
            "                            <em class=\"replyNum\" title=\"Replies\"><a href=\"/index.php?mid=board_cUlO13&amp;document_srl=5972502#comment\">15</a></em>\n" +
            "                                                    <span class=\"icon\"><img src=\"http://kbdlab.co.kr/modules/document/tpl/icons//update.gif\" alt=\"update\" title=\"update\" style=\"margin-right:2px;\" /></span>\n" +
            "                    </td>\n" +
            "                </tr>\n" +
            "                <tr>\n" +
            "                <td class=\"title\">\n" +
            "                                    <a href=\"/index.php?mid=board_cUlO13&amp;document_srl=5967815\">레오폴드 FC660M 청축 타건영상</a>\n" +
            "                            <em class=\"replyNum\" title=\"Replies\"><a href=\"/index.php?mid=board_cUlO13&amp;document_srl=5967815#comment\">2</a></em>\n" +
            "                                                    <span class=\"icon\"></span>\n" +
            "                    </td>\n" +
            "                </tr>\n" +
            "                <tr>\n" +
            "                <td class=\"title\">\n" +
            "                                    <a href=\"/index.php?mid=board_cUlO13&amp;document_srl=5964629\">안녕하세요. 금벌레 입니다.</a>\n" +
            "                            <em class=\"replyNum\" title=\"Replies\"><a href=\"/index.php?mid=board_cUlO13&amp;document_srl=5964629#comment\">18</a></em>\n" +
            "                                                    <span class=\"icon\"></span>\n" +
            "                    </td>\n" +
            "                </tr>\n" +
            "                <tr>\n" +
            "                <td class=\"title\">\n" +
            "                                    <a href=\"/index.php?mid=board_cUlO13&amp;document_srl=5963655\">구형 키보드 황변제거입니다.</a>\n" +
            "                            <em class=\"replyNum\" title=\"Replies\"><a href=\"/index.php?mid=board_cUlO13&amp;document_srl=5963655#comment\">26</a></em>\n" +
            "                                                    <span class=\"icon\"><img src=\"http://kbdlab.co.kr/modules/document/tpl/icons//file.gif\" alt=\"file\" title=\"file\" style=\"margin-right:2px;\" /></span>\n" +
            "                    </td>\n" +
            "                </tr>\n" +
            "                </tbody>\n" +
            "    </table>\n" +
            "        </div>\n" +
            "</div>  </div>\n" +
            "</div>\n" +
            "</div><div class=\"xe-widget-wrapper \" style=\"margin: 0px 10px 0px 0px; border: 0px solid rgb(255, 255, 255); width: 360px; float: left; background-image: none; background-repeat: repeat; background-color: rgb(255, 255, 255);\"><div class=\"ws_nico\">\n" +
            "  <div class=\"css3pie ws_nico_title\" style=\"\">\n" +
            "          <a href=\"http://kbdlab.co.kr/board_CDST33\">\n" +
            "              묻고 답하기            </a>\n" +
            "        <div class=\"ws_nico_arrow_border\"></div>\n" +
            "    <div class=\"ws_nico_arrow_bg\" ></div>\n" +
            "  </div>\n" +
            "  <div class=\"ws_nico_content ws_nico_border\">\n" +
            "    <div style=\"*zoom:1;padding:0px 0px 0px 0px !important;\"><div class=\"widgetContainer\">\n" +
            "                    <table class=\"widgetTableA\" border=\"1\" cellspacing=\"0\">\n" +
            "        <tbody>\n" +
            "                <tr>\n" +
            "                <td class=\"title\">\n" +
            "                                        <a href=\"http://kbdlab.co.kr/index.php?mid=board_CDST33&amp;category=52002\"><strong class=\"category\">커스텀</strong></a>\n" +
            "                        <a href=\"/index.php?mid=board_CDST33&amp;document_srl=5974039\">tx87se 에 이퀄츠 기판 적용 문의</a>\n" +
            "                            <em class=\"replyNum\" title=\"Replies\"><a href=\"/index.php?mid=board_CDST33&amp;document_srl=5974039#comment\">2</a></em>\n" +
            "                                                    <span class=\"icon\"><img src=\"http://kbdlab.co.kr/modules/document/tpl/icons//new.gif\" alt=\"new\" title=\"new\" style=\"margin-right:2px;\" /></span>\n" +
            "                    </td>\n" +
            "                </tr>\n" +
            "                <tr>\n" +
            "                <td class=\"title\">\n" +
            "                                        <a href=\"http://kbdlab.co.kr/index.php?mid=board_CDST33&amp;category=52002\"><strong class=\"category\">커스텀</strong></a>\n" +
            "                        <a href=\"/index.php?mid=board_CDST33&amp;document_srl=5972802\">밤색으로 재아노해주는 업체 있을까요??</a>\n" +
            "                            <em class=\"replyNum\" title=\"Replies\"><a href=\"/index.php?mid=board_CDST33&amp;document_srl=5972802#comment\">2</a></em>\n" +
            "                                                    <span class=\"icon\"><img src=\"http://kbdlab.co.kr/modules/document/tpl/icons//file.gif\" alt=\"file\" title=\"file\" style=\"margin-right:2px;\" /></span>\n" +
            "                    </td>\n" +
            "                </tr>\n" +
            "                <tr>\n" +
            "                <td class=\"title\">\n" +
            "                                        <a href=\"http://kbdlab.co.kr/index.php?mid=board_CDST33&amp;category=52003\"><strong class=\"category\">기성품</strong></a>\n" +
            "                        <a href=\"/index.php?mid=board_CDST33&amp;document_srl=5972551\">카일백축 pbt vs abs</a>\n" +
            "                            <em class=\"replyNum\" title=\"Replies\"><a href=\"/index.php?mid=board_CDST33&amp;document_srl=5972551#comment\">1</a></em>\n" +
            "                                                    <span class=\"icon\"></span>\n" +
            "                    </td>\n" +
            "                </tr>\n" +
            "                <tr>\n" +
            "                <td class=\"title\">\n" +
            "                                        <a href=\"http://kbdlab.co.kr/index.php?mid=board_CDST33&amp;category=52024\"><strong class=\"category\">기　타</strong></a>\n" +
            "                        <a href=\"/index.php?mid=board_CDST33&amp;document_srl=5972089\">usb용 전선은 어디서 구입해야 될까요</a>\n" +
            "                            <em class=\"replyNum\" title=\"Replies\"><a href=\"/index.php?mid=board_CDST33&amp;document_srl=5972089#comment\">4</a></em>\n" +
            "                                                    <span class=\"icon\"></span>\n" +
            "                    </td>\n" +
            "                </tr>\n" +
            "                <tr>\n" +
            "                <td class=\"title\">\n" +
            "                                        <a href=\"http://kbdlab.co.kr/index.php?mid=board_CDST33&amp;category=52002\"><strong class=\"category\">커스텀</strong></a>\n" +
            "                        <a href=\"/index.php?mid=board_CDST33&amp;document_srl=5972019\">키캡을 찾다가 가장 원하는 배열을 찾았는데 어디서 찾아 볼수 있는지 모르겠습니다.</a>\n" +
            "                            <em class=\"replyNum\" title=\"Replies\"><a href=\"/index.php?mid=board_CDST33&amp;document_srl=5972019#comment\">4</a></em>\n" +
            "                                                    <span class=\"icon\"><img src=\"http://kbdlab.co.kr/modules/document/tpl/icons//update.gif\" alt=\"update\" title=\"update\" style=\"margin-right:2px;\" /><img src=\"http://kbdlab.co.kr/modules/document/tpl/icons//file.gif\" alt=\"file\" title=\"file\" style=\"margin-right:2px;\" /></span>\n" +
            "                    </td>\n" +
            "                </tr>\n" +
            "                </tbody>\n" +
            "    </table>\n" +
            "        </div>\n" +
            "</div>  </div>\n" +
            "</div>\n" +
            "</div><div class=\"xe_content xe-widget-wrapper \" style=\"width: 100%; float: left;\"><div style=\"padding:0px 0px 0px 0px !important;\"><b>\n" +
            "<p><br /></p>\n" +
            "<p><br /></p>\n" +
            "\n" +
            "</b></div></div><div class=\"xe-widget-wrapper \" style=\"margin: 0px 10px 0px 0px; border: 0px solid rgb(255, 255, 255); width: 360px; float: left; background-image: none; background-repeat: repeat; background-color: rgb(255, 255, 255);\"><div class=\"ws_nico\">\n" +
            "  <div class=\"css3pie ws_nico_title\" style=\"\">\n" +
            "          <a href=\"http://kbdlab.co.kr/board_fleamarket\">\n" +
            "              장터            </a>\n" +
            "        <div class=\"ws_nico_arrow_border\"></div>\n" +
            "    <div class=\"ws_nico_arrow_bg\" ></div>\n" +
            "  </div>\n" +
            "  <div class=\"ws_nico_content ws_nico_border\">\n" +
            "    <div style=\"*zoom:1;padding:0px 0px 0px 0px !important;\"><div class=\"widgetContainer\">\n" +
            "                    <table class=\"widgetTableA\" border=\"1\" cellspacing=\"0\">\n" +
            "        <tbody>\n" +
            "                <tr>\n" +
            "                <td class=\"title\">\n" +
            "                                        <a href=\"http://kbdlab.co.kr/index.php?mid=board_fleamarket&amp;category=16125\"><strong class=\"category\">구매</strong></a>\n" +
            "                        <a href=\"/index.php?mid=board_fleamarket&amp;document_srl=5974155\">홀리판다 구해봅니다</a>\n" +
            "                                                    <span class=\"icon\"><img src=\"http://kbdlab.co.kr/modules/document/tpl/icons//new.gif\" alt=\"new\" title=\"new\" style=\"margin-right:2px;\" /></span>\n" +
            "                    </td>\n" +
            "                </tr>\n" +
            "                <tr>\n" +
            "                <td class=\"title\">\n" +
            "                                        <a href=\"http://kbdlab.co.kr/index.php?mid=board_fleamarket&amp;category=16125\"><strong class=\"category\">구매</strong></a>\n" +
            "                        <a href=\"/index.php?mid=board_fleamarket&amp;document_srl=5974059\">Jane v2 ver.ce, GMK 모던돌치, 린야르 삽니다</a>\n" +
            "                                                    <span class=\"icon\"><img src=\"http://kbdlab.co.kr/modules/document/tpl/icons//new.gif\" alt=\"new\" title=\"new\" style=\"margin-right:2px;\" /></span>\n" +
            "                    </td>\n" +
            "                </tr>\n" +
            "                <tr>\n" +
            "                <td class=\"title\">\n" +
            "                                        <a href=\"http://kbdlab.co.kr/index.php?mid=board_fleamarket&amp;category=16119\"><strong class=\"category\">판매</strong></a>\n" +
            "                        <a href=\"/index.php?mid=board_fleamarket&amp;document_srl=5974016\">햄승 체리킷, 튤립 포인트킷, 윈키리스킷 (R1) 팜니다(일괄)</a>\n" +
            "                                                    <span class=\"icon\"><img src=\"http://kbdlab.co.kr/modules/document/tpl/icons//new.gif\" alt=\"new\" title=\"new\" style=\"margin-right:2px;\" /><img src=\"http://kbdlab.co.kr/modules/document/tpl/icons//file.gif\" alt=\"file\" title=\"file\" style=\"margin-right:2px;\" /></span>\n" +
            "                    </td>\n" +
            "                </tr>\n" +
            "                <tr>\n" +
            "                <td class=\"title\">\n" +
            "                                        <a href=\"http://kbdlab.co.kr/index.php?mid=board_fleamarket&amp;category=16119\"><strong class=\"category\">판매</strong></a>\n" +
            "                        <a href=\"/index.php?mid=board_fleamarket&amp;document_srl=5974028\">TE 홀타이트 판매합니다.(가격인하)</a>\n" +
            "                                                    <span class=\"icon\"><img src=\"http://kbdlab.co.kr/modules/document/tpl/icons//new.gif\" alt=\"new\" title=\"new\" style=\"margin-right:2px;\" /><img src=\"http://kbdlab.co.kr/modules/document/tpl/icons//file.gif\" alt=\"file\" title=\"file\" style=\"margin-right:2px;\" /></span>\n" +
            "                    </td>\n" +
            "                </tr>\n" +
            "                <tr>\n" +
            "                <td class=\"title\">\n" +
            "                                        <a href=\"http://kbdlab.co.kr/index.php?mid=board_fleamarket&amp;category=16119\"><strong class=\"category\">판매</strong></a>\n" +
            "                        <a href=\"/index.php?mid=board_fleamarket&amp;document_srl=5974009\">니우40 카일제이드 판매</a>\n" +
            "                                                    <span class=\"icon\"><img src=\"http://kbdlab.co.kr/modules/document/tpl/icons//new.gif\" alt=\"new\" title=\"new\" style=\"margin-right:2px;\" /><img src=\"http://kbdlab.co.kr/modules/document/tpl/icons//file.gif\" alt=\"file\" title=\"file\" style=\"margin-right:2px;\" /></span>\n" +
            "                    </td>\n" +
            "                </tr>\n" +
            "                </tbody>\n" +
            "    </table>\n" +
            "        </div>\n" +
            "</div>  </div>\n" +
            "</div>\n" +
            "</div><div class=\"xe-widget-wrapper \" style=\"margin: 0px 10px 0px 0px; border: 0px solid rgb(255, 255, 255); width: 360px; float: left; background-image: none; background-repeat: repeat; background-color: rgb(255, 255, 255);\"><div class=\"ws_nico\">\n" +
            "  <div class=\"css3pie ws_nico_title\" style=\"\">\n" +
            "          <a href=\"http://kbdlab.co.kr/park\">\n" +
            "              쉼터            </a>\n" +
            "        <div class=\"ws_nico_arrow_border\"></div>\n" +
            "    <div class=\"ws_nico_arrow_bg\" ></div>\n" +
            "  </div>\n" +
            "  <div class=\"ws_nico_content ws_nico_border\">\n" +
            "    <div style=\"*zoom:1;padding:0px 0px 0px 0px !important;\"><div class=\"widgetContainer\">\n" +
            "                    <table class=\"widgetTableA\" border=\"1\" cellspacing=\"0\">\n" +
            "        <tbody>\n" +
            "                <tr>\n" +
            "                <td class=\"title\">\n" +
            "                                    <a href=\"/index.php?mid=board_twFR55&amp;document_srl=5958816\">직장인 YES 강도</a>\n" +
            "                            <em class=\"replyNum\" title=\"Replies\"><a href=\"/index.php?mid=board_twFR55&amp;document_srl=5958816#comment\">2</a></em>\n" +
            "                                                    <span class=\"icon\"><img src=\"http://kbdlab.co.kr/modules/document/tpl/icons//file.gif\" alt=\"file\" title=\"file\" style=\"margin-right:2px;\" /></span>\n" +
            "                    </td>\n" +
            "                </tr>\n" +
            "                <tr>\n" +
            "                <td class=\"title\">\n" +
            "                                    <a href=\"/index.php?mid=board_twFR55&amp;document_srl=5892206\">앞으로는 자주 빙그레 투게더를 먹어야겠습니다.</a>\n" +
            "                            <em class=\"replyNum\" title=\"Replies\"><a href=\"/index.php?mid=board_twFR55&amp;document_srl=5892206#comment\">1</a></em>\n" +
            "                                                    <span class=\"icon\"></span>\n" +
            "                    </td>\n" +
            "                </tr>\n" +
            "                <tr>\n" +
            "                <td class=\"title\">\n" +
            "                                    <a href=\"/index.php?mid=board_twFR55&amp;document_srl=5797785\">천하제일 혐라면 대회 jpg</a>\n" +
            "                            <em class=\"replyNum\" title=\"Replies\"><a href=\"/index.php?mid=board_twFR55&amp;document_srl=5797785#comment\">4</a></em>\n" +
            "                                                    <span class=\"icon\"><img src=\"http://kbdlab.co.kr/modules/document/tpl/icons//file.gif\" alt=\"file\" title=\"file\" style=\"margin-right:2px;\" /></span>\n" +
            "                    </td>\n" +
            "                </tr>\n" +
            "                <tr>\n" +
            "                <td class=\"title\">\n" +
            "                                    <a href=\"/index.php?mid=board_twFR55&amp;document_srl=5750524\">맛있게 보이는 후라이드~~~!!</a>\n" +
            "                            <em class=\"replyNum\" title=\"Replies\"><a href=\"/index.php?mid=board_twFR55&amp;document_srl=5750524#comment\">1</a></em>\n" +
            "                                                    <span class=\"icon\"></span>\n" +
            "                    </td>\n" +
            "                </tr>\n" +
            "                <tr>\n" +
            "                <td class=\"title\">\n" +
            "                                    <a href=\"/index.php?mid=board_twFR55&amp;document_srl=5693326\">내일은 삼일절 입니다.</a>\n" +
            "                            <em class=\"replyNum\" title=\"Replies\"><a href=\"/index.php?mid=board_twFR55&amp;document_srl=5693326#comment\">2</a></em>\n" +
            "                                                    <span class=\"icon\"></span>\n" +
            "                    </td>\n" +
            "                </tr>\n" +
            "                </tbody>\n" +
            "    </table>\n" +
            "        </div>\n" +
            "</div>  </div>\n" +
            "</div>\n" +
            "</div><div class=\"xe_content xe-widget-wrapper \" style=\"width: 100%; float: left;\"><div style=\"padding:0px 0px 0px 0px !important;\"><b>\n" +
            "\n" +
            "<p><br /></p>\n" +
            "<p><b><br /></b></p>\n" +
            "</b></div></div><div class=\"xe-widget-wrapper \" style=\"margin: 0px 10px 0px 0px; border: 0px solid rgb(255, 255, 255); width: 360px; float: left; background-image: none; background-repeat: repeat; background-color: rgb(255, 255, 255);\"><div class=\"ws_nico\">\n" +
            "  <div class=\"css3pie ws_nico_title\" style=\"\">\n" +
            "          <a href=\"http://kbdlab.co.kr/index.php?mid=board_gb_outside\">\n" +
            "              공제/공구 새로운 소식            </a>\n" +
            "        <div class=\"ws_nico_arrow_border\"></div>\n" +
            "    <div class=\"ws_nico_arrow_bg\" ></div>\n" +
            "  </div>\n" +
            "  <div class=\"ws_nico_content ws_nico_border\">\n" +
            "    <div style=\"*zoom:1;padding:0px 0px 0px 0px !important;\"><div class=\"widgetContainer\">\n" +
            "                    <table class=\"widgetTableA\" border=\"1\" cellspacing=\"0\">\n" +
            "        <tbody>\n" +
            "                <tr>\n" +
            "                <td class=\"title\">\n" +
            "                                    <a href=\"/index.php?mid=board_gb_outside&amp;document_srl=5974285\">gmk yugo (11/4 ~ 12/15)</a>\n" +
            "                                                    <span class=\"icon\"><img src=\"http://kbdlab.co.kr/modules/document/tpl/icons//new.gif\" alt=\"new\" title=\"new\" style=\"margin-right:2px;\" /><img src=\"http://kbdlab.co.kr/modules/document/tpl/icons//file.gif\" alt=\"file\" title=\"file\" style=\"margin-right:2px;\" /></span>\n" +
            "                    </td>\n" +
            "                </tr>\n" +
            "                <tr>\n" +
            "                <td class=\"title\">\n" +
            "                                    <a href=\"/index.php?mid=board_gb_outside&amp;document_srl=5972655\">gmk terra (11/4 ~ 12/1)</a>\n" +
            "                            <em class=\"replyNum\" title=\"Replies\"><a href=\"/index.php?mid=board_gb_outside&amp;document_srl=5972655#comment\">5</a></em>\n" +
            "                                                    <span class=\"icon\"><img src=\"http://kbdlab.co.kr/modules/document/tpl/icons//file.gif\" alt=\"file\" title=\"file\" style=\"margin-right:2px;\" /></span>\n" +
            "                    </td>\n" +
            "                </tr>\n" +
            "                <tr>\n" +
            "                <td class=\"title\">\n" +
            "                                    <a href=\"/index.php?mid=board_gb_outside&amp;document_srl=5971559\">HSA White on Black, Beige on Brown (11/1 ~ 11/30)</a>\n" +
            "                            <em class=\"replyNum\" title=\"Replies\"><a href=\"/index.php?mid=board_gb_outside&amp;document_srl=5971559#comment\">6</a></em>\n" +
            "                                                    <span class=\"icon\"><img src=\"http://kbdlab.co.kr/modules/document/tpl/icons//file.gif\" alt=\"file\" title=\"file\" style=\"margin-right:2px;\" /></span>\n" +
            "                    </td>\n" +
            "                </tr>\n" +
            "                <tr>\n" +
            "                <td class=\"title\">\n" +
            "                                    <a href=\"/index.php?mid=board_gb_outside&amp;document_srl=5970648\">gmk Umbra (11/1 ~ 11/30)</a>\n" +
            "                            <em class=\"replyNum\" title=\"Replies\"><a href=\"/index.php?mid=board_gb_outside&amp;document_srl=5970648#comment\">2</a></em>\n" +
            "                                                    <span class=\"icon\"><img src=\"http://kbdlab.co.kr/modules/document/tpl/icons//file.gif\" alt=\"file\" title=\"file\" style=\"margin-right:2px;\" /></span>\n" +
            "                    </td>\n" +
            "                </tr>\n" +
            "                <tr>\n" +
            "                <td class=\"title\">\n" +
            "                                    <a href=\"/index.php?mid=board_gb_outside&amp;document_srl=5970630\">gmk shark bait (11/1 ~ 12/1)</a>\n" +
            "                            <em class=\"replyNum\" title=\"Replies\"><a href=\"/index.php?mid=board_gb_outside&amp;document_srl=5970630#comment\">1</a></em>\n" +
            "                                                    <span class=\"icon\"><img src=\"http://kbdlab.co.kr/modules/document/tpl/icons//file.gif\" alt=\"file\" title=\"file\" style=\"margin-right:2px;\" /></span>\n" +
            "                    </td>\n" +
            "                </tr>\n" +
            "                </tbody>\n" +
            "    </table>\n" +
            "        </div>\n" +
            "</div>  </div>\n" +
            "</div>\n" +
            "</div><div class=\"xe-widget-wrapper \" style=\"margin: 0px 10px 0px 0px; border: 0px solid rgb(255, 255, 255); width: 360px; float: left; background-image: none; background-repeat: repeat; background-color: rgb(255, 255, 255);\"><div class=\"ws_nico\">\n" +
            "  <div class=\"css3pie ws_nico_title\" style=\"\">\n" +
            "          <a href=\"http://kbdlab.co.kr/index.php?mid=board_gb_do\">\n" +
            "              공제/공구 진행 소식            </a>\n" +
            "        <div class=\"ws_nico_arrow_border\"></div>\n" +
            "    <div class=\"ws_nico_arrow_bg\" ></div>\n" +
            "  </div>\n" +
            "  <div class=\"ws_nico_content ws_nico_border\">\n" +
            "    <div style=\"*zoom:1;padding:0px 0px 0px 0px !important;\"><div class=\"widgetContainer\">\n" +
            "                    <table class=\"widgetTableA\" border=\"1\" cellspacing=\"0\">\n" +
            "        <tbody>\n" +
            "                <tr>\n" +
            "                <td class=\"title\">\n" +
            "                                    <a href=\"/index.php?mid=board_gb_do&amp;document_srl=5973602\"><span style=\"font-weight:bold;color:#EE2222\">C³-LDN RGB80% PCB 공제 진행합니다.</span></a>\n" +
            "                            <em class=\"replyNum\" title=\"Replies\"><a href=\"/index.php?mid=board_gb_do&amp;document_srl=5973602#comment\">27</a></em>\n" +
            "                                                    <span class=\"icon\"><img src=\"http://kbdlab.co.kr/modules/document/tpl/icons//new.gif\" alt=\"new\" title=\"new\" style=\"margin-right:2px;\" /></span>\n" +
            "                    </td>\n" +
            "                </tr>\n" +
            "                <tr>\n" +
            "                <td class=\"title\">\n" +
            "                                    <a href=\"/index.php?mid=board_gb_do&amp;document_srl=5960456\"><span style=\"font-weight:bold;color:#EE2222\">[진행] ㄲㅣㅇㄲㅗㅇ DGL 8X custom keyboard</span></a>\n" +
            "                            <em class=\"replyNum\" title=\"Replies\"><a href=\"/index.php?mid=board_gb_do&amp;document_srl=5960456#comment\">12</a></em>\n" +
            "                                                    <span class=\"icon\"></span>\n" +
            "                    </td>\n" +
            "                </tr>\n" +
            "                <tr>\n" +
            "                <td class=\"title\">\n" +
            "                                    <a href=\"/index.php?mid=board_groupbuy_build&amp;document_srl=5944734\">특주 돌고래 버스 관련해서 유의사항을 듣고 싶습니다</a>\n" +
            "                            <em class=\"replyNum\" title=\"Replies\"><a href=\"/index.php?mid=board_groupbuy_build&amp;document_srl=5944734#comment\">27</a></em>\n" +
            "                                                    <span class=\"icon\"></span>\n" +
            "                    </td>\n" +
            "                </tr>\n" +
            "                <tr>\n" +
            "                <td class=\"title\">\n" +
            "                                    <a href=\"/index.php?mid=board_gb_do&amp;document_srl=5926346\"><span style=\"font-weight:bold;color:#88AA66\">&lt;출고완료&gt;공포의군주키캡 공제합니다-업데이트일 20191028</span></a>\n" +
            "                            <em class=\"replyNum\" title=\"Replies\"><a href=\"/index.php?mid=board_gb_do&amp;document_srl=5926346#comment\">40</a></em>\n" +
            "                                                    <span class=\"icon\"></span>\n" +
            "                    </td>\n" +
            "                </tr>\n" +
            "                <tr>\n" +
            "                <td class=\"title\">\n" +
            "                                    <a href=\"/index.php?mid=board_gb_do&amp;document_srl=5907599\"><span style=\"font-weight:bold;color:#88AA66\">밤비신청마감 입금확인및 가공시작</span></a>\n" +
            "                            <em class=\"replyNum\" title=\"Replies\"><a href=\"/index.php?mid=board_gb_do&amp;document_srl=5907599#comment\">73</a></em>\n" +
            "                                                    <span class=\"icon\"><img src=\"http://kbdlab.co.kr/modules/document/tpl/icons//file.gif\" alt=\"file\" title=\"file\" style=\"margin-right:2px;\" /></span>\n" +
            "                    </td>\n" +
            "                </tr>\n" +
            "                </tbody>\n" +
            "    </table>\n" +
            "        </div>\n" +
            "</div>  </div>\n" +
            "</div>\n" +
            "</div><div class=\"xe_content xe-widget-wrapper \" style=\"width: 100%; float: left;\"><div style=\"padding:0px 0px 0px 0px !important;\"><b>\n" +
            "<p><br /></p>\n" +
            "<p><br /></p>\n" +
            "\n" +
            "</b></div></div><div class=\"xe-widget-wrapper \" style=\"margin: 0px; border: 0px solid rgb(255, 255, 255); width: 100%; float: left; background-image: none; background-repeat: repeat; background-color: rgb(255, 255, 255);\"><div class=\"ws_nico\">\n" +
            "  <div class=\"css3pie ws_nico_title\" style=\"\">\n" +
            "          <a href=\"http://kbdlab.co.kr/page_Tjjg00\">\n" +
            "              공방 소식            </a>\n" +
            "        <div class=\"ws_nico_arrow_border\"></div>\n" +
            "    <div class=\"ws_nico_arrow_bg\" ></div>\n" +
            "  </div>\n" +
            "  <div class=\"ws_nico_content\">\n" +
            "    <div style=\"*zoom:1;padding:0px 0px 0px 0px !important;\"><div class=\"widgetContainer\">\n" +
            "                    <table class=\"widgetTableA\" border=\"1\" cellspacing=\"0\">\n" +
            "        <tbody>\n" +
            "                <tr>\n" +
            "                <td class=\"title\">\n" +
            "                    \n" +
            "                <a href=\"http://kbdlab.co.kr/index.php?mid=board_gqHn82\"><strong class=\"board\">02공방</strong></a>\n" +
            "                                    <a href=\"/index.php?mid=board_gqHn82&amp;document_srl=5973727\">스노프로 tkl 기판 문의드립니다</a>\n" +
            "                            <em class=\"replyNum\" title=\"Replies\"><a href=\"/index.php?mid=board_gqHn82&amp;document_srl=5973727#comment\">1</a></em>\n" +
            "                                                    <span class=\"icon\"><img src=\"http://kbdlab.co.kr/modules/document/tpl/icons//new.gif\" alt=\"new\" title=\"new\" style=\"margin-right:2px;\" /></span>\n" +
            "                    </td>\n" +
            "                    <td class=\"time\"><span class=\"date\">2019-11-04</span> <span class=\"hour\">14:29</span></td>\n" +
            "                    <td><a href=\"#\" onclick=\"return false;\" class=\"author member_458916\" ><img src=\"http://kbdlab.co.kr/modules/point/icons/kbdlab/3.gif\" alt=\"[레벨:3]\" title=\"포인트:963point (67%), 레벨:3/100\" class=\"xe_point_level_icon\" style=\"vertical-align:middle;margin-right:3px;\" />이꼬</a></td>\n" +
            "                </tr>\n" +
            "                <tr>\n" +
            "                <td class=\"title\">\n" +
            "                    \n" +
            "                <a href=\"http://kbdlab.co.kr/index.php?mid=board_FMrM24\"><strong class=\"board\">힝힝홍힝</strong></a>\n" +
            "                                        <a href=\"http://kbdlab.co.kr/index.php?mid=board_FMrM24&amp;category=5021705\"><strong class=\"category\">의뢰문의</strong></a>\n" +
            "                        <a href=\"/index.php?mid=board_FMrM24&amp;document_srl=5973713\">안녕하세요. 의뢰 문의 드려요.</a>\n" +
            "                                                    <span class=\"icon\"><img src=\"http://kbdlab.co.kr/modules/document/tpl/icons//new.gif\" alt=\"new\" title=\"new\" style=\"margin-right:2px;\" /></span>\n" +
            "                    </td>\n" +
            "                    <td class=\"time\"><span class=\"date\">2019-11-04</span> <span class=\"hour\">14:25</span></td>\n" +
            "                    <td><a href=\"#\" onclick=\"return false;\" class=\"author member_4349817\" ><img src=\"http://kbdlab.co.kr/modules/point/icons/kbdlab/31.gif\" alt=\"[레벨:31]\" title=\"포인트:68677point (31%), 레벨:31/100\" class=\"xe_point_level_icon\" style=\"vertical-align:middle;margin-right:3px;\" />Time_is_ing</a></td>\n" +
            "                </tr>\n" +
            "                <tr>\n" +
            "                <td class=\"title\">\n" +
            "                    \n" +
            "                <a href=\"http://kbdlab.co.kr/index.php?mid=board_kbdfactorys\"><strong class=\"board\">키보드공장장</strong></a>\n" +
            "                                    <a href=\"/index.php?mid=board_kbdfactorys&amp;document_srl=5973551\">풀윤활 흡음제 추가 문의드립니다.</a>\n" +
            "                            <em class=\"replyNum\" title=\"Replies\"><a href=\"/index.php?mid=board_kbdfactorys&amp;document_srl=5973551#comment\">1</a></em>\n" +
            "                                                    <span class=\"icon\"><img src=\"http://kbdlab.co.kr/modules/document/tpl/icons//new.gif\" alt=\"new\" title=\"new\" style=\"margin-right:2px;\" /></span>\n" +
            "                    </td>\n" +
            "                    <td class=\"time\"><span class=\"date\">2019-11-04</span> <span class=\"hour\">12:35</span></td>\n" +
            "                    <td><a href=\"#\" onclick=\"return false;\" class=\"author member_5967900\" ><img src=\"http://kbdlab.co.kr/modules/point/icons/kbdlab/1.gif\" alt=\"[레벨:1]\" title=\"포인트:244point (82%), 레벨:1/100\" class=\"xe_point_level_icon\" style=\"vertical-align:middle;margin-right:3px;\" />갓둘</a></td>\n" +
            "                </tr>\n" +
            "                <tr>\n" +
            "                <td class=\"title\">\n" +
            "                    \n" +
            "                <a href=\"http://kbdlab.co.kr/index.php?mid=board_kbdfactorys\"><strong class=\"board\">키보드공장장</strong></a>\n" +
            "                                    <a href=\"/index.php?mid=board_kbdfactorys&amp;document_srl=5972798\">tx87se 조립 및 스위치 윤활 견적 문의 드립니다.</a>\n" +
            "                            <em class=\"replyNum\" title=\"Replies\"><a href=\"/index.php?mid=board_kbdfactorys&amp;document_srl=5972798#comment\">1</a></em>\n" +
            "                                                    <span class=\"icon\"></span>\n" +
            "                    </td>\n" +
            "                    <td class=\"time\"><span class=\"date\">2019-11-03</span> <span class=\"hour\">19:49</span></td>\n" +
            "                    <td><a href=\"#\" onclick=\"return false;\" class=\"author member_5207638\" ><img src=\"http://kbdlab.co.kr/modules/point/icons/kbdlab/1.gif\" alt=\"[레벨:1]\" title=\"포인트:228point (75%), 레벨:1/100\" class=\"xe_point_level_icon\" style=\"vertical-align:middle;margin-right:3px;\" />레몬머랭쿠키</a></td>\n" +
            "                </tr>\n" +
            "                <tr>\n" +
            "                <td class=\"title\">\n" +
            "                    \n" +
            "                <a href=\"http://kbdlab.co.kr/index.php?mid=board_kbdfactorys\"><strong class=\"board\">키보드공장장</strong></a>\n" +
            "                                    <a href=\"/index.php?mid=board_kbdfactorys&amp;document_srl=5972470\">로지텍 지프로 스테빌 파손</a>\n" +
            "                            <em class=\"replyNum\" title=\"Replies\"><a href=\"/index.php?mid=board_kbdfactorys&amp;document_srl=5972470#comment\">1</a></em>\n" +
            "                                                    <span class=\"icon\"></span>\n" +
            "                    </td>\n" +
            "                    <td class=\"time\"><span class=\"date\">2019-11-03</span> <span class=\"hour\">10:07</span></td>\n" +
            "                    <td><a href=\"#\" onclick=\"return false;\" class=\"author member_5660273\" ><img src=\"http://kbdlab.co.kr/modules/point/icons/kbdlab/2.gif\" alt=\"[레벨:2]\" title=\"포인트:355point (21%), 레벨:2/100\" class=\"xe_point_level_icon\" style=\"vertical-align:middle;margin-right:3px;\" />키보드23094</a></td>\n" +
            "                </tr>\n" +
            "                <tr>\n" +
            "                <td class=\"title\">\n" +
            "                    \n" +
            "                <a href=\"http://kbdlab.co.kr/index.php?mid=board_kbdfactorys\"><strong class=\"board\">키보드공장장</strong></a>\n" +
            "                                    <a href=\"/index.php?mid=board_kbdfactorys&amp;document_srl=5971795\">Tx 87se 조립및 윤활 문의드립니다</a>\n" +
            "                            <em class=\"replyNum\" title=\"Replies\"><a href=\"/index.php?mid=board_kbdfactorys&amp;document_srl=5971795#comment\">1</a></em>\n" +
            "                                                    <span class=\"icon\"></span>\n" +
            "                    </td>\n" +
            "                    <td class=\"time\"><span class=\"date\">2019-11-02</span> <span class=\"hour\">12:50</span></td>\n" +
            "                    <td><a href=\"#\" onclick=\"return false;\" class=\"author member_5852995\" ><img src=\"http://kbdlab.co.kr/modules/point/icons/kbdlab/3.gif\" alt=\"[레벨:3]\" title=\"포인트:843point (43%), 레벨:3/100\" class=\"xe_point_level_icon\" style=\"vertical-align:middle;margin-right:3px;\" />simschool</a></td>\n" +
            "                </tr>\n" +
            "                <tr>\n" +
            "                <td class=\"title\">\n" +
            "                    \n" +
            "                <a href=\"http://kbdlab.co.kr/index.php?mid=board_gqHn82\"><strong class=\"board\">02공방</strong></a>\n" +
            "                                    <a href=\"/index.php?mid=board_gqHn82&amp;document_srl=5971177\">스노우 프로 tkl 7.1 기판 질문드립니다</a>\n" +
            "                            <em class=\"replyNum\" title=\"Replies\"><a href=\"/index.php?mid=board_gqHn82&amp;document_srl=5971177#comment\">3</a></em>\n" +
            "                                                    <span class=\"icon\"></span>\n" +
            "                    </td>\n" +
            "                    <td class=\"time\"><span class=\"date\">2019-11-01</span> <span class=\"hour\">22:27</span></td>\n" +
            "                    <td><a href=\"#\" onclick=\"return false;\" class=\"author member_5018520\" ><img src=\"http://kbdlab.co.kr/modules/point/icons/kbdlab/6.gif\" alt=\"[레벨:6]\" title=\"포인트:2799point (30%), 레벨:6/100\" class=\"xe_point_level_icon\" style=\"vertical-align:middle;margin-right:3px;\" />sama4477</a></td>\n" +
            "                </tr>\n" +
            "                <tr>\n" +
            "                <td class=\"title\">\n" +
            "                    \n" +
            "                <a href=\"http://kbdlab.co.kr/index.php?mid=board_kbdfactorys\"><strong class=\"board\">키보드공장장</strong></a>\n" +
            "                                    <a href=\"/index.php?mid=board_kbdfactorys&amp;document_srl=5970858\">tx87se 조립 및 윤활 문의드립니다</a>\n" +
            "                            <em class=\"replyNum\" title=\"Replies\"><a href=\"/index.php?mid=board_kbdfactorys&amp;document_srl=5970858#comment\">3</a></em>\n" +
            "                                                    <span class=\"icon\"></span>\n" +
            "                    </td>\n" +
            "                    <td class=\"time\"><span class=\"date\">2019-11-01</span> <span class=\"hour\">16:18</span></td>\n" +
            "                    <td><a href=\"#\" onclick=\"return false;\" class=\"author member_5573320\" ><img src=\"http://kbdlab.co.kr/modules/point/icons/kbdlab/7.gif\" alt=\"[레벨:7]\" title=\"포인트:4339point (86%), 레벨:7/100\" class=\"xe_point_level_icon\" style=\"vertical-align:middle;margin-right:3px;\" />슬픈울보</a></td>\n" +
            "                </tr>\n" +
            "                <tr>\n" +
            "                <td class=\"title\">\n" +
            "                    \n" +
            "                <a href=\"http://kbdlab.co.kr/index.php?mid=board_kbdfactorys\"><strong class=\"board\">키보드공장장</strong></a>\n" +
            "                                    <a href=\"/index.php?mid=board_kbdfactorys&amp;document_srl=5970835\">TX87 조립 및 윤활 견적문의.</a>\n" +
            "                            <em class=\"replyNum\" title=\"Replies\"><a href=\"/index.php?mid=board_kbdfactorys&amp;document_srl=5970835#comment\">1</a></em>\n" +
            "                                                    <span class=\"icon\"></span>\n" +
            "                    </td>\n" +
            "                    <td class=\"time\"><span class=\"date\">2019-11-01</span> <span class=\"hour\">15:55</span></td>\n" +
            "                    <td><a href=\"#\" onclick=\"return false;\" class=\"author member_5559223\" ><img src=\"http://kbdlab.co.kr/modules/point/icons/kbdlab/2.gif\" alt=\"[레벨:2]\" title=\"포인트:566point (81%), 레벨:2/100\" class=\"xe_point_level_icon\" style=\"vertical-align:middle;margin-right:3px;\" />쩔엇다</a></td>\n" +
            "                </tr>\n" +
            "                <tr>\n" +
            "                <td class=\"title\">\n" +
            "                    \n" +
            "                <a href=\"http://kbdlab.co.kr/index.php?mid=board_FMrM24\"><strong class=\"board\">힝힝홍힝</strong></a>\n" +
            "                                        <a href=\"http://kbdlab.co.kr/index.php?mid=board_FMrM24&amp;category=5021705\"><strong class=\"category\">의뢰문의</strong></a>\n" +
            "                        <a href=\"/index.php?mid=board_FMrM24&amp;document_srl=5970722\">풀윤활, 흡음 의뢰 드립니다.</a>\n" +
            "                                                    <span class=\"icon\"></span>\n" +
            "                    </td>\n" +
            "                    <td class=\"time\"><span class=\"date\">2019-11-01</span> <span class=\"hour\">14:50</span></td>\n" +
            "                    <td><a href=\"#\" onclick=\"return false;\" class=\"author member_5736567\" ><img src=\"http://kbdlab.co.kr/modules/point/icons/kbdlab/1.gif\" alt=\"[레벨:1]\" title=\"포인트:170point (47%), 레벨:1/100\" class=\"xe_point_level_icon\" style=\"vertical-align:middle;margin-right:3px;\" />로건</a></td>\n" +
            "                </tr>\n" +
            "                </tbody>\n" +
            "    </table>\n" +
            "        </div>\n" +
            "</div>  </div>\n" +
            "</div>\n" +
            "</div><div class=\"xe_content xe-widget-wrapper \" style=\"width: 100%; float: left;\"><div style=\"padding:0px 0px 0px 0px !important;\"><b>\n" +
            "<p><br /></p>\n" +
            "<p><br /></p>\n" +
            "\n" +
            "</b></div></div><div class=\"xe-widget-wrapper \" style=\"margin: 0px; border: 0px solid rgb(255, 255, 255); width: 100%; float: left; background-image: none; background-repeat: repeat; background-color: rgb(255, 255, 255);\"><div class=\"ws_nico\">\n" +
            "  <div class=\"css3pie ws_nico_title\" style=\"\">\n" +
            "          <a href=\"http://kbdlab.co.kr/review\">\n" +
            "              제품 리뷰            </a>\n" +
            "        <div class=\"ws_nico_arrow_border\"></div>\n" +
            "    <div class=\"ws_nico_arrow_bg\" ></div>\n" +
            "  </div>\n" +
            "  <div class=\"ws_nico_content\">\n" +
            "    <div style=\"*zoom:1;padding:0px 0px 0px 0px !important;\"><div class=\"apzwidgetContainer\">\n" +
            "        <ul class=\"apzwidgetGalleryA\" style=\"width:699px;\">\n" +
            "        <li style=\"width:223px;\">\n" +
            "                                \t\n" +
            "            \t<div class=\"tmb_wrp\">\n" +
            "                <a href=\"/index.php?mid=board_gogm32&amp;document_srl=5877924\" class=\"thumb\" style=\"width:223px;height:180px\">\n" +
            "                                            <img class=\"tmb\" src=\"http://kbdlab.co.kr/files/thumbnails/924/877/005/223x180.crop.jpg\" style=\"width:223px;height:180px\"/ width=\"223\" height=\"180\">\n" +
            "                                                        <strong class=\"board\">기타</strong>\n" +
            "                                \t<div class=\"view\">\n" +
            "                \t\t \n" +
            "                \t</div>\n" +
            "                \t\n" +
            "                </a>\n" +
            "            \t</div>\n" +
            "            \n" +
            "                     \n" +
            "                    \n" +
            "            <div class=\"heading\" style=\"width:193px;\">        \n" +
            "                  <p class=\"meta\">\n" +
            "                     \n" +
            "\t\t          \t\t             <span>August 8, 08</span>   \n" +
            "                   \n" +
            "                                       </br> <span><a href=\"/index.php?mid=board_gogm32&amp;document_srl=5877924#comment\">0 Comments</a></span>\n" +
            "                                    \n" +
            "                                    \t <span><a href=\"#\" onclick=\"return false;\" style=\"color:#fff\" class=\"author member_5898\"><img src=\"http://kbdlab.co.kr/modules/point/icons/kbdlab/34.gif\" alt=\"[레벨:34]\" title=\"포인트:81148point (4%), 레벨:34/100\" class=\"xe_point_level_icon\" style=\"vertical-align:middle;margin-right:3px;\" />월광가면</a></span>\n" +
            "                  \t\t\n" +
            "                  </p>\n" +
            "                     \n" +
            "                  <h2><a href=\"/index.php?mid=board_gogm32&amp;document_srl=5877924\">[집중탐구] I♥U - 리줌 RK201 크리스탈 키캡 러브 키보드</a></h2>\n" +
            "                  \n" +
            "                                    \t                    \n" +
            "            </div>\n" +
            "                        \n" +
            "                     \n" +
            "                            \t\t\n" +
            "            \t\t\n" +
            "                     \n" +
            "                            \t\t\n" +
            "                     \n" +
            "              \n" +
            "    </li>\n" +
            "            <li style=\"width:223px;\">\n" +
            "                                \t\n" +
            "            \t<div class=\"tmb_wrp\">\n" +
            "                <a href=\"/index.php?mid=board_gogm32&amp;document_srl=5829240\" class=\"thumb\" style=\"width:223px;height:180px\">\n" +
            "                                            <img class=\"tmb\" src=\"http://kbdlab.co.kr/files/thumbnails/240/829/005/223x180.crop.jpg\" style=\"width:223px;height:180px\"/ width=\"223\" height=\"180\">\n" +
            "                                                        <strong class=\"board\">기타</strong>\n" +
            "                                \t<div class=\"view\">\n" +
            "                \t\t \n" +
            "                \t</div>\n" +
            "                \t\n" +
            "                </a>\n" +
            "            \t</div>\n" +
            "            \n" +
            "                     \n" +
            "                    \n" +
            "            <div class=\"heading\" style=\"width:193px;\">        \n" +
            "                  <p class=\"meta\">\n" +
            "                     \n" +
            "\t\t          \t\t             <span>June 6, 22</span>   \n" +
            "                   \n" +
            "                                       </br> <span><a href=\"/index.php?mid=board_gogm32&amp;document_srl=5829240#comment\">2 Comments</a></span>\n" +
            "                                    \n" +
            "                                    \t <span><a href=\"#\" onclick=\"return false;\" style=\"color:#fff\" class=\"author member_5898\"><img src=\"http://kbdlab.co.kr/modules/point/icons/kbdlab/34.gif\" alt=\"[레벨:34]\" title=\"포인트:81148point (4%), 레벨:34/100\" class=\"xe_point_level_icon\" style=\"vertical-align:middle;margin-right:3px;\" />월광가면</a></span>\n" +
            "                  \t\t\n" +
            "                  </p>\n" +
            "                     \n" +
            "                  <h2><a href=\"/index.php?mid=board_gogm32&amp;document_srl=5829240\">[집중탐구] 타이폰 MARS PRO MK2 기계식 키보드 (흑축)</a></h2>\n" +
            "                  \n" +
            "                                    \t                    \n" +
            "            </div>\n" +
            "                        \n" +
            "                     \n" +
            "                            \t\t\n" +
            "            \t\t\n" +
            "                     \n" +
            "                            \t\t\n" +
            "                     \n" +
            "              \n" +
            "    </li>\n" +
            "            <li style=\"width:223px;\">\n" +
            "                                \t\n" +
            "            \t<div class=\"tmb_wrp\">\n" +
            "                <a href=\"/index.php?mid=board_gogm32&amp;document_srl=5797194\" class=\"thumb\" style=\"width:223px;height:180px\">\n" +
            "                                            <img class=\"tmb\" src=\"http://kbdlab.co.kr/files/thumbnails/194/797/005/223x180.crop.jpg\" style=\"width:223px;height:180px\"/ width=\"223\" height=\"180\">\n" +
            "                                                        <strong class=\"board\">기타</strong>\n" +
            "                                \t<div class=\"view\">\n" +
            "                \t\t \n" +
            "                \t</div>\n" +
            "                \t\n" +
            "                </a>\n" +
            "            \t</div>\n" +
            "            \n" +
            "                     \n" +
            "                    \n" +
            "            <div class=\"heading\" style=\"width:193px;\">        \n" +
            "                  <p class=\"meta\">\n" +
            "                     \n" +
            "\t\t          \t\t             <span>May 5, 21</span>   \n" +
            "                   \n" +
            "                                       </br> <span><a href=\"/index.php?mid=board_gogm32&amp;document_srl=5797194#comment\">0 Comments</a></span>\n" +
            "                                    \n" +
            "                                    \t <span><a href=\"#\" onclick=\"return false;\" style=\"color:#fff\" class=\"author member_5530819\"><img src=\"http://kbdlab.co.kr/modules/point/icons/kbdlab/7.gif\" alt=\"[레벨:7]\" title=\"포인트:3430point (0%), 레벨:7/100\" class=\"xe_point_level_icon\" style=\"vertical-align:middle;margin-right:3px;\" />drugfish</a></span>\n" +
            "                  \t\t\n" +
            "                  </p>\n" +
            "                     \n" +
            "                  <h2><a href=\"/index.php?mid=board_gogm32&amp;document_srl=5797194\">IBM Model F (XT)_내용 추가</a></h2>\n" +
            "                  \n" +
            "                                    \t                    \n" +
            "            </div>\n" +
            "                        \n" +
            "                     \n" +
            "                            \t\t\n" +
            "            \t\t\n" +
            "                     \n" +
            "                            \t\t\n" +
            "                     \n" +
            "              \n" +
            "    </li>\n" +
            "        </ul>\n" +
            "</div>\n" +
            "</div>  </div>\n" +
            "</div>\n" +
            "</div><div class=\"xe_content xe-widget-wrapper \" style=\"width: 100%; float: left;\"><div style=\"padding:0px 0px 0px 0px !important;\"><b>\n" +
            "<p><br /></p>\n" +
            "<p><br /></p>\n" +
            "\n" +
            "</b></div></div><div class=\"xe-widget-wrapper \" style=\"margin: 0px; border: 0px solid rgb(255, 255, 255); width: 100%; float: left; background-image: none; background-repeat: repeat; background-color: rgb(255, 255, 255);\"><div class=\"ws_nico\">\n" +
            "  <div class=\"css3pie ws_nico_title\" style=\"\">\n" +
            "          <a href=\"http://kbdlab.co.kr/index.php?mid=board_zoSQ99\">\n" +
            "              IT 신제품 소식            </a>\n" +
            "        <div class=\"ws_nico_arrow_border\"></div>\n" +
            "    <div class=\"ws_nico_arrow_bg\" ></div>\n" +
            "  </div>\n" +
            "  <div class=\"ws_nico_content\">\n" +
            "    <div style=\"*zoom:1;padding:0px 0px 0px 0px !important;\"><div class=\"apzwidgetContainer\">\n" +
            "        <ul class=\"apzwidgetGalleryA\" style=\"width:699px;\">\n" +
            "        <li style=\"width:223px;\">\n" +
            "                                \t\n" +
            "            \t<div class=\"tmb_wrp\">\n" +
            "                <a href=\"/index.php?mid=board_zoSQ99&amp;document_srl=5898624\" class=\"thumb\" style=\"width:223px;height:180px\">\n" +
            "                                            <span class=\"imgNone\">이미지 없음</span>\n" +
            "                                                        <strong class=\"board\">IT 신제품 소식</strong>\n" +
            "                                \t<div class=\"view\">\n" +
            "                \t\t \n" +
            "                \t</div>\n" +
            "                \t\n" +
            "                </a>\n" +
            "            \t</div>\n" +
            "            \n" +
            "                     \n" +
            "                    \n" +
            "            <div class=\"heading\" style=\"width:193px;\">        \n" +
            "                  <p class=\"meta\">\n" +
            "                  \t\t             <span><a>키보드</a></span> - \n" +
            "\t\t             \n" +
            "\t\t          \t\t             <span>August 8, 25</span>   \n" +
            "                   \n" +
            "                                       </br> <span><a href=\"/index.php?mid=board_zoSQ99&amp;document_srl=5898624#comment\">0 Comments</a></span>\n" +
            "                                    \n" +
            "                                    \t <span><a href=\"#\" onclick=\"return false;\" style=\"color:#fff\" class=\"author member_4362470\"><img src=\"http://kbdlab.co.kr/modules/point/icons/kbdlab/21.gif\" alt=\"[레벨:21]\" title=\"포인트:31493point (20%), 레벨:21/100\" class=\"xe_point_level_icon\" style=\"vertical-align:middle;margin-right:3px;\" />아오기리</a></span>\n" +
            "                  \t\t\n" +
            "                  </p>\n" +
            "                     \n" +
            "                  <h2><a href=\"/index.php?mid=board_zoSQ99&amp;document_srl=5898624\">해피해킹 블루투스 키보드 리뷰영상</a></h2>\n" +
            "                  \n" +
            "                                    \t                    \n" +
            "            </div>\n" +
            "                        \n" +
            "                     \n" +
            "                            \t\t\n" +
            "            \t\t\n" +
            "                     \n" +
            "                            \t\t\n" +
            "                     \n" +
            "              \n" +
            "    </li>\n" +
            "            <li style=\"width:223px;\">\n" +
            "                                \t\n" +
            "            \t<div class=\"tmb_wrp\">\n" +
            "                <a href=\"/index.php?mid=board_zoSQ99&amp;document_srl=5505528\" class=\"thumb\" style=\"width:223px;height:180px\">\n" +
            "                                            <span class=\"imgNone\">이미지 없음</span>\n" +
            "                                                        <strong class=\"board\">IT 신제품 소식</strong>\n" +
            "                                \t<div class=\"view\">\n" +
            "                \t\t \n" +
            "                \t</div>\n" +
            "                \t\n" +
            "                </a>\n" +
            "            \t</div>\n" +
            "            \n" +
            "                     \n" +
            "                    \n" +
            "            <div class=\"heading\" style=\"width:193px;\">        \n" +
            "                  <p class=\"meta\">\n" +
            "                  \t\t             <span><a>키　캡</a></span> - \n" +
            "\t\t             \n" +
            "\t\t          \t\t             <span>October 10, 30</span>   \n" +
            "                   \n" +
            "                                       </br> <span><a href=\"/index.php?mid=board_zoSQ99&amp;document_srl=5505528#comment\">2 Comments</a></span>\n" +
            "                                    \n" +
            "                                    \t <span><a href=\"#\" onclick=\"return false;\" style=\"color:#fff\" class=\"author member_3869005\"><img src=\"http://kbdlab.co.kr/modules/point/icons/kbdlab/7.gif\" alt=\"[레벨:7]\" title=\"포인트:4286point (81%), 레벨:7/100\" class=\"xe_point_level_icon\" style=\"vertical-align:middle;margin-right:3px;\" />쁼릴리</a></span>\n" +
            "                  \t\t\n" +
            "                  </p>\n" +
            "                     \n" +
            "                  <h2><a href=\"/index.php?mid=board_zoSQ99&amp;document_srl=5505528\">techkeys에서 :~$ynth 3.0 판매 시작</a></h2>\n" +
            "                  \n" +
            "                                    \t                    \n" +
            "            </div>\n" +
            "                        \n" +
            "                     \n" +
            "                            \t\t\n" +
            "            \t\t\n" +
            "                     \n" +
            "                            \t\t\n" +
            "                     \n" +
            "              \n" +
            "    </li>\n" +
            "            <li style=\"width:223px;\">\n" +
            "                                \t\n" +
            "            \t<div class=\"tmb_wrp\">\n" +
            "                <a href=\"/index.php?mid=board_zoSQ99&amp;document_srl=4784146\" class=\"thumb\" style=\"width:223px;height:180px\">\n" +
            "                                            <span class=\"imgNone\">이미지 없음</span>\n" +
            "                                                        <strong class=\"board\">IT 신제품 소식</strong>\n" +
            "                                \t<div class=\"view\">\n" +
            "                \t\t \n" +
            "                \t</div>\n" +
            "                \t\n" +
            "                </a>\n" +
            "            \t</div>\n" +
            "            \n" +
            "                     \n" +
            "                    \n" +
            "            <div class=\"heading\" style=\"width:193px;\">        \n" +
            "                  <p class=\"meta\">\n" +
            "                  \t\t             <span><a>HW/SW</a></span> - \n" +
            "\t\t             \n" +
            "\t\t          \t\t             <span>October 10, 30</span>   \n" +
            "                   \n" +
            "                                       </br> <span><a href=\"/index.php?mid=board_zoSQ99&amp;document_srl=4784146#comment\">3 Comments</a></span>\n" +
            "                                    \n" +
            "                                    \t <span><a href=\"#\" onclick=\"return false;\" style=\"color:#fff\" class=\"author member_73701\"><img src=\"http://kbdlab.co.kr/modules/point/icons/kbdlab/2.gif\" alt=\"[레벨:2]\" title=\"포인트:333point (15%), 레벨:2/100\" class=\"xe_point_level_icon\" style=\"vertical-align:middle;margin-right:3px;\" />은근한</a></span>\n" +
            "                  \t\t\n" +
            "                  </p>\n" +
            "                     \n" +
            "                  <h2><a href=\"/index.php?mid=board_zoSQ99&amp;document_srl=4784146\">”Rev-O-mate” assist your creative design/art works</a></h2>\n" +
            "                  \n" +
            "                                    \t                    \n" +
            "            </div>\n" +
            "                        \n" +
            "                     \n" +
            "                            \t\t\n" +
            "            \t\t\n" +
            "                     \n" +
            "                            \t\t\n" +
            "                     \n" +
            "              \n" +
            "    </li>\n" +
            "        </ul>\n" +
            "</div>\n" +
            "</div>  </div>\n" +
            "</div>\n" +
            "</div><div class=\"xe_content xe-widget-wrapper \" style=\"width: 100%; float: left;\"><div style=\"padding:0px 0px 0px 0px !important;\"><b>\n" +
            "<p><br /></p>\n" +
            "<p><br /></p>\n" +
            "\n" +
            "</b></div></div><div class=\"xe-widget-wrapper \" style=\"margin: 0px; border: 0px solid rgb(255, 255, 255); width: 100%; float: left; background-image: none; background-repeat: repeat; background-color: rgb(255, 255, 255);\"><div class=\"ws_nico\">\n" +
            "  <div class=\"css3pie ws_nico_title\" style=\"\">\n" +
            "          <a href=\"http://kbdlab.co.kr/index.php?mid=lab\">\n" +
            "              연구실 소식            </a>\n" +
            "        <div class=\"ws_nico_arrow_border\"></div>\n" +
            "    <div class=\"ws_nico_arrow_bg\" ></div>\n" +
            "  </div>\n" +
            "  <div class=\"ws_nico_content\">\n" +
            "    <div style=\"*zoom:1;padding:0px 0px 0px 0px !important;\"><div class=\"widgetContainer\">\n" +
            "                    <table class=\"widgetTableA\" border=\"1\" cellspacing=\"0\">\n" +
            "        <tbody>\n" +
            "                <tr>\n" +
            "                <td class=\"title\">\n" +
            "                    \n" +
            "                <a href=\"http://kbdlab.co.kr/index.php?mid=board_bvJm72\"><strong class=\"board\">키보드 레이아웃 연구실</strong></a>\n" +
            "                                    <a href=\"/index.php?mid=board_bvJm72&amp;document_srl=5965736\">남는 numpad 키캡이 아까워서 만들어본 배열</a>\n" +
            "                            <em class=\"replyNum\" title=\"Replies\"><a href=\"/index.php?mid=board_bvJm72&amp;document_srl=5965736#comment\">3</a></em>\n" +
            "                                                    <span class=\"icon\"><img src=\"http://kbdlab.co.kr/modules/document/tpl/icons//file.gif\" alt=\"file\" title=\"file\" style=\"margin-right:2px;\" /></span>\n" +
            "                    </td>\n" +
            "                    <td class=\"time\"><span class=\"date\">2019-10-28</span> <span class=\"hour\">10:31</span></td>\n" +
            "                    <td><a href=\"#\" onclick=\"return false;\" class=\"author member_4054446\" ><img src=\"http://kbdlab.co.kr/modules/point/icons/kbdlab/8.gif\" alt=\"[레벨:8]\" title=\"포인트:5475point (83%), 레벨:8/100\" class=\"xe_point_level_icon\" style=\"vertical-align:middle;margin-right:3px;\" />축소지향</a></td>\n" +
            "                </tr>\n" +
            "                <tr>\n" +
            "                <td class=\"title\">\n" +
            "                    \n" +
            "                <a href=\"http://kbdlab.co.kr/index.php?mid=board_bvJm72\"><strong class=\"board\">키보드 레이아웃 연구실</strong></a>\n" +
            "                                    <a href=\"/index.php?mid=board_bvJm72&amp;document_srl=5916023\"><span style=\"font-weight:bold;color:#ff0000\">2019 KBDLAB 기판 제작 프로젝트 (5차 업데이트 2019-10-18)</span></a>\n" +
            "                            <em class=\"replyNum\" title=\"Replies\"><a href=\"/index.php?mid=board_bvJm72&amp;document_srl=5916023#comment\">53</a></em>\n" +
            "                                                    <span class=\"icon\"><img src=\"http://kbdlab.co.kr/modules/document/tpl/icons//file.gif\" alt=\"file\" title=\"file\" style=\"margin-right:2px;\" /></span>\n" +
            "                    </td>\n" +
            "                    <td class=\"time\"><span class=\"date\">2019-09-09</span> <span class=\"hour\">13:33</span></td>\n" +
            "                    <td><a href=\"#\" onclick=\"return false;\" class=\"author member_131\" ><img src=\"http://kbdlab.co.kr/modules/point/icons/kbdlab/34.gif\" alt=\"[레벨:34]\" title=\"포인트:83602point (55%), 레벨:34/100\" class=\"xe_point_level_icon\" style=\"vertical-align:middle;margin-right:3px;\" />duck0113</a></td>\n" +
            "                </tr>\n" +
            "                <tr>\n" +
            "                <td class=\"title\">\n" +
            "                    \n" +
            "                <a href=\"http://kbdlab.co.kr/index.php?mid=board_bvJm72\"><strong class=\"board\">키보드 레이아웃 연구실</strong></a>\n" +
            "                                    <a href=\"/index.php?mid=board_bvJm72&amp;document_srl=5893905\">HHKB와 660M을 품은 60% 레이아웃</a>\n" +
            "                            <em class=\"replyNum\" title=\"Replies\"><a href=\"/index.php?mid=board_bvJm72&amp;document_srl=5893905#comment\">2</a></em>\n" +
            "                                                    <span class=\"icon\"><img src=\"http://kbdlab.co.kr/modules/document/tpl/icons//file.gif\" alt=\"file\" title=\"file\" style=\"margin-right:2px;\" /></span>\n" +
            "                    </td>\n" +
            "                    <td class=\"time\"><span class=\"date\">2019-08-22</span> <span class=\"hour\">13:25</span></td>\n" +
            "                    <td><a href=\"#\" onclick=\"return false;\" class=\"author member_5453443\" ><img src=\"http://kbdlab.co.kr/modules/point/icons/kbdlab/36.gif\" alt=\"[레벨:36]\" title=\"포인트:90725point (0%), 레벨:36/100\" class=\"xe_point_level_icon\" style=\"vertical-align:middle;margin-right:3px;\" />장성철</a></td>\n" +
            "                </tr>\n" +
            "                <tr>\n" +
            "                <td class=\"title\">\n" +
            "                    \n" +
            "                <a href=\"http://kbdlab.co.kr/index.php?mid=board_bvJm72\"><strong class=\"board\">키보드 레이아웃 연구실</strong></a>\n" +
            "                                    <a href=\"/index.php?mid=board_bvJm72&amp;document_srl=5860572\">윈키리스 최종 매핑</a>\n" +
            "                            <em class=\"replyNum\" title=\"Replies\"><a href=\"/index.php?mid=board_bvJm72&amp;document_srl=5860572#comment\">1</a></em>\n" +
            "                                                    <span class=\"icon\"><img src=\"http://kbdlab.co.kr/modules/document/tpl/icons//file.gif\" alt=\"file\" title=\"file\" style=\"margin-right:2px;\" /></span>\n" +
            "                    </td>\n" +
            "                    <td class=\"time\"><span class=\"date\">2019-07-23</span> <span class=\"hour\">02:04</span></td>\n" +
            "                    <td><a href=\"#\" onclick=\"return false;\" class=\"author member_4403651\" ><img src=\"http://kbdlab.co.kr/modules/point/icons/kbdlab/12.gif\" alt=\"[레벨:12]\" title=\"포인트:10452point (21%), 레벨:12/100\" class=\"xe_point_level_icon\" style=\"vertical-align:middle;margin-right:3px;\" />범</a></td>\n" +
            "                </tr>\n" +
            "                <tr>\n" +
            "                <td class=\"title\">\n" +
            "                    \n" +
            "                <a href=\"http://kbdlab.co.kr/index.php?mid=board_bvJm72\"><strong class=\"board\">키보드 레이아웃 연구실</strong></a>\n" +
            "                                    <a href=\"/index.php?mid=board_bvJm72&amp;document_srl=5748843\">제가 쓰고 있는 배열</a>\n" +
            "                                                    <span class=\"icon\"><img src=\"http://kbdlab.co.kr/modules/document/tpl/icons//file.gif\" alt=\"file\" title=\"file\" style=\"margin-right:2px;\" /></span>\n" +
            "                    </td>\n" +
            "                    <td class=\"time\"><span class=\"date\">2019-04-09</span> <span class=\"hour\">03:03</span></td>\n" +
            "                    <td><a href=\"#\" onclick=\"return false;\" class=\"author member_349758\" ><img src=\"http://kbdlab.co.kr/modules/point/icons/kbdlab/1.gif\" alt=\"[레벨:1]\" title=\"포인트:232point (77%), 레벨:1/100\" class=\"xe_point_level_icon\" style=\"vertical-align:middle;margin-right:3px;\" />우아왜</a></td>\n" +
            "                </tr>\n" +
            "                </tbody>\n" +
            "    </table>\n" +
            "        </div>\n" +
            "</div>  </div>\n" +
            "</div>\n" +
            "</div><div class=\"xe_content xe-widget-wrapper \" style=\"width: 100%; float: left;\"><div style=\"padding:0px 0px 0px 0px !important;\"><b>\n" +
            "<p><br /></p>\n" +
            "<p><br /></p>\n" +
            "\n" +
            "</b></div></div><div class=\"xe-widget-wrapper \" style=\"margin: 0px; border: 0px solid rgb(255, 255, 255); width: 100%; float: left; background-image: none; background-repeat: repeat; background-color: rgb(255, 255, 255);\"><div class=\"ws_nico\">\n" +
            "  <div class=\"css3pie ws_nico_title\" style=\"\">\n" +
            "          <a href=\"http://kbdlab.co.kr/index.php?mid=board_DLSF53\">\n" +
            "              키보드랩 공헌자 목록            </a>\n" +
            "        <div class=\"ws_nico_arrow_border\"></div>\n" +
            "    <div class=\"ws_nico_arrow_bg\" ></div>\n" +
            "  </div>\n" +
            "  <div class=\"ws_nico_content\">\n" +
            "    <div style=\"*zoom:1;padding:0px 0px 0px 0px !important;\"><div class=\"widgetContainer\">\n" +
            "                    <table class=\"widgetTableA\" border=\"1\" cellspacing=\"0\">\n" +
            "        <tbody>\n" +
            "                <tr>\n" +
            "                <td class=\"title\">\n" +
            "                                    <a href=\"/index.php?mid=board_DLSF53&amp;document_srl=5105502\">[운영비 지원] 입금자 대표 benkei 님 2018년 3월 15일</a>\n" +
            "                                                    <span class=\"icon\"></span>\n" +
            "                    </td>\n" +
            "                    <td class=\"time\"><span class=\"date\">2018-03-19</span> <span class=\"hour\">11:33</span></td>\n" +
            "                    <td><a href=\"#\" onclick=\"return false;\" class=\"author member_4\" ><img src=\"http://kbdlab.co.kr/modules/point/icons/kbdlab/18.gif\" alt=\"[레벨:18]\" title=\"포인트:24749point (79%), 레벨:18/100\" class=\"xe_point_level_icon\" style=\"vertical-align:middle;margin-right:3px;\" />트루커스텀</a></td>\n" +
            "                </tr>\n" +
            "                <tr>\n" +
            "                <td class=\"title\">\n" +
            "                                    <a href=\"/index.php?mid=board_DLSF53&amp;document_srl=5105497\">[운영비 지원] 입금자 대표 우공™님 2018년 3월 15일</a>\n" +
            "                                                    <span class=\"icon\"></span>\n" +
            "                    </td>\n" +
            "                    <td class=\"time\"><span class=\"date\">2018-03-19</span> <span class=\"hour\">11:32</span></td>\n" +
            "                    <td><a href=\"#\" onclick=\"return false;\" class=\"author member_4\" ><img src=\"http://kbdlab.co.kr/modules/point/icons/kbdlab/18.gif\" alt=\"[레벨:18]\" title=\"포인트:24749point (79%), 레벨:18/100\" class=\"xe_point_level_icon\" style=\"vertical-align:middle;margin-right:3px;\" />트루커스텀</a></td>\n" +
            "                </tr>\n" +
            "                <tr>\n" +
            "                <td class=\"title\">\n" +
            "                                    <a href=\"/index.php?mid=board_DLSF53&amp;document_srl=5089135\">[운영비 지원] 입금자 대표 Bone.D.Roid 님 2018년 1월 30일</a>\n" +
            "                                                    <span class=\"icon\"></span>\n" +
            "                    </td>\n" +
            "                    <td class=\"time\"><span class=\"date\">2018-03-12</span> <span class=\"hour\">11:06</span></td>\n" +
            "                    <td><a href=\"#\" onclick=\"return false;\" class=\"author member_4\" ><img src=\"http://kbdlab.co.kr/modules/point/icons/kbdlab/18.gif\" alt=\"[레벨:18]\" title=\"포인트:24749point (79%), 레벨:18/100\" class=\"xe_point_level_icon\" style=\"vertical-align:middle;margin-right:3px;\" />트루커스텀</a></td>\n" +
            "                </tr>\n" +
            "                <tr>\n" +
            "                <td class=\"title\">\n" +
            "                                    <a href=\"/index.php?mid=board_DLSF53&amp;document_srl=5089130\">[운영비 지원] 입금자 대표 힝힝홍힝 님 2017년 11월 27일</a>\n" +
            "                                                    <span class=\"icon\"></span>\n" +
            "                    </td>\n" +
            "                    <td class=\"time\"><span class=\"date\">2018-03-12</span> <span class=\"hour\">11:03</span></td>\n" +
            "                    <td><a href=\"#\" onclick=\"return false;\" class=\"author member_4\" ><img src=\"http://kbdlab.co.kr/modules/point/icons/kbdlab/18.gif\" alt=\"[레벨:18]\" title=\"포인트:24749point (79%), 레벨:18/100\" class=\"xe_point_level_icon\" style=\"vertical-align:middle;margin-right:3px;\" />트루커스텀</a></td>\n" +
            "                </tr>\n" +
            "                <tr>\n" +
            "                <td class=\"title\">\n" +
            "                                    <a href=\"/index.php?mid=board_DLSF53&amp;document_srl=4565989\">[운영비 지원] 입금자 대표 브라이스님 2017년 7월 22일</a>\n" +
            "                                                    <span class=\"icon\"></span>\n" +
            "                    </td>\n" +
            "                    <td class=\"time\"><span class=\"date\">2017-08-03</span> <span class=\"hour\">10:52</span></td>\n" +
            "                    <td><a href=\"#\" onclick=\"return false;\" class=\"author member_4\" ><img src=\"http://kbdlab.co.kr/modules/point/icons/kbdlab/18.gif\" alt=\"[레벨:18]\" title=\"포인트:24749point (79%), 레벨:18/100\" class=\"xe_point_level_icon\" style=\"vertical-align:middle;margin-right:3px;\" />트루커스텀</a></td>\n" +
            "                </tr>\n" +
            "                </tbody>\n" +
            "    </table>\n" +
            "        </div>\n" +
            "</div>  </div>\n" +
            "</div>\n" +
            "</div><div class=\"xe_content xe-widget-wrapper \" style=\"width: 100%; float: left;\"><div style=\"padding:0px 0px 0px 0px !important;\"><b>\n" +
            "<p><br /></p>\n" +
            "<p><br /></p>\n" +
            "\n" +
            "</b></div></div><div class=\"xe-widget-wrapper \" style=\"width: 100%; float: left;\"><div class=\"ws_nico\">\n" +
            "  <div class=\"css3pie ws_nico_title\" style=\"\">\n" +
            "          <a href=\"http://kbdlab.co.kr/index.php?mid=home&act=dispAttendancePersonalInfo\">\n" +
            "              출석부            </a>\n" +
            "        <div class=\"ws_nico_arrow_border\"></div>\n" +
            "    <div class=\"ws_nico_arrow_bg\" ></div>\n" +
            "  </div>\n" +
            "  <div class=\"ws_nico_content\">\n" +
            "    <div style=\"*zoom:1;padding:0px 0px 0px 0px !important;\"><script type=\"text/javascript\">\n" +
            "    var warn_msg = '중복출석 방지를 위해 한번만 눌러주세요.';\n" +
            "</script>\n" +
            "\t\t<div class=\"addon_view\">\n" +
            "    </div>\n" +
            "<table cellspacing=\"0\" class=\"attendanceTable\">\n" +
            "        <thead>\n" +
            "\t<tr> \n" +
            "\t\t<th class=\"bold\" >순위</th>\t\t\t\t<th class=\"bold\" >별명</th>\t\t\t\t\t\t<th class=\"bold\" >당일기록</th>                <th class=\"bold\" >인사말</th>\t</tr>\n" +
            "    </thead>\n" +
            "    \t\n" +
            "\t\t\t\t\t\n" +
            "\t            \t\n" +
            "\t\t\t\t\t\t\n" +
            "\t\t                            \t\n" +
            "    <tbody>\n" +
            "\t<tr class=\"lines\">\n" +
            "\t\t<td class=\"center\" >1</td>\t\t\t\t\t\t<td ><div class=\"nick_name member_4003572\"><img src=\"http://kbdlab.co.kr/modules/point/icons/kbdlab/19.gif\" alt=\"[레벨:19]\" title=\"포인트:26702point (52%), 레벨:19/100\" class=\"xe_point_level_icon\" style=\"vertical-align:middle;margin-right:3px;\" />Cork</div></td>\t\t\t\t\t\t<td class=\"center\" >35</td>        \n" +
            "        \t\t\n" +
            "        \t\t\t<td >\n" +
            "                                    <div class=\"greetings\" ><a href=\"/index.php?mid=attendance&amp;selected_date=20191104\">출석했어요</a></div>\n" +
            "                \t\t\t</td>\n" +
            "\t\t\t</tr>\n" +
            "    </tbody>\n" +
            "\t\t\t\t\t\t\t\n" +
            "\t\t                            \t\n" +
            "    <tbody>\n" +
            "\t<tr class=\"lines\">\n" +
            "\t\t<td class=\"center\" >2</td>\t\t\t\t\t\t<td ><div class=\"nick_name member_190538\"><img src=\"http://kbdlab.co.kr/modules/point/icons/kbdlab/37.gif\" alt=\"[레벨:37]\" title=\"포인트:97469point (31%), 레벨:37/100\" class=\"xe_point_level_icon\" style=\"vertical-align:middle;margin-right:3px;\" />blood372</div></td>\t\t\t\t\t\t<td class=\"center\" >20</td>        \n" +
            "        \t\t\n" +
            "        \t\t\t<td >\n" +
            "                                    <div class=\"greetings\" ><a href=\"/index.php?mid=attendance&amp;selected_date=20191104\">출석했어요</a></div>\n" +
            "                \t\t\t</td>\n" +
            "\t\t\t</tr>\n" +
            "    </tbody>\n" +
            "\t\t\t\t\t\t\t\n" +
            "\t\t                            \t\n" +
            "    <tbody>\n" +
            "\t<tr class=\"lines\">\n" +
            "\t\t<td class=\"center\" >3</td>\t\t\t\t\t\t<td ><div class=\"nick_name member_4068904\"><img src=\"http://kbdlab.co.kr/modules/point/icons/kbdlab/22.gif\" alt=\"[레벨:22]\" title=\"포인트:34080point (6%), 레벨:22/100\" class=\"xe_point_level_icon\" style=\"vertical-align:middle;margin-right:3px;\" />tipo33</div></td>\t\t\t\t\t\t<td class=\"center\" >10</td>        \n" +
            "        \t\t\n" +
            "        \t\t\t<td >\n" +
            "                                    <div class=\"greetings\" ><a href=\"/index.php?mid=attendance&amp;selected_date=20191104\">출석했어요</a></div>\n" +
            "                \t\t\t</td>\n" +
            "\t\t\t</tr>\n" +
            "    </tbody>\n" +
            "\t\t\t\t\t\t\t\n" +
            "\t\t                            \t\n" +
            "    <tbody>\n" +
            "\t<tr class=\"lines\">\n" +
            "\t\t<td class=\"center\" >4</td>\t\t\t\t\t\t<td ><div class=\"nick_name member_4012935\"><img src=\"http://kbdlab.co.kr/modules/point/icons/kbdlab/25.gif\" alt=\"[레벨:25]\" title=\"포인트:44140point (10%), 레벨:25/100\" class=\"xe_point_level_icon\" style=\"vertical-align:middle;margin-right:3px;\" />이삭</div></td>\t\t\t\t\t\t<td class=\"center\" >5</td>        \n" +
            "        \t\t\n" +
            "        \t\t\t<td >\n" +
            "                                    <div class=\"greetings\" ><a href=\"/index.php?mid=attendance&amp;selected_date=20191104\">출석했어요</a></div>\n" +
            "                \t\t\t</td>\n" +
            "\t\t\t</tr>\n" +
            "    </tbody>\n" +
            "\t\t\t\t\t\t\t\n" +
            "\t\t                            \t\n" +
            "    <tbody>\n" +
            "\t<tr class=\"lines\">\n" +
            "\t\t<td class=\"center\" >5</td>\t\t\t\t\t\t<td ><div class=\"nick_name member_5231083\"><img src=\"http://kbdlab.co.kr/modules/point/icons/kbdlab/10.gif\" alt=\"[레벨:10]\" title=\"포인트:8217point (82%), 레벨:10/100\" class=\"xe_point_level_icon\" style=\"vertical-align:middle;margin-right:3px;\" />에이에푸</div></td>\t\t\t\t\t\t<td class=\"center\" >5</td>        \n" +
            "        \t\t\n" +
            "        \t\t\t<td >\n" +
            "                                    <div class=\"greetings\" >\n" +
            "                                            \t\t\t            <a href=\"/index.php?mid=attendance&amp;selected_date=20191104\">출석합니다.</a>\n" +
            "                                                                </div>\n" +
            "                \t\t\t</td>\n" +
            "\t\t\t</tr>\n" +
            "    </tbody>\n" +
            "\t\t</table>\n" +
            "<div class=\"paging\">\n" +
            "\t\n" +
            "\t<div id=\"date\">\n" +
            "\t\t<a href=\"/index.php?mid=home&amp;choose_date=20191103\">←</a>\n" +
            "\t\t\t <a href=\"/index.php?mid=home&amp;choose_date=20191104\">2019-11-04</a>\n" +
            "\t\t<a href=\"/index.php?mid=home&amp;choose_date=20191105\"> →</a>\n" +
            "\t</div> \n" +
            "\t<div id=\"page_no\">\n" +
            "   <a href=\"/index.php?mid=home&amp;page=1\" class=\"prevEnd\">←</a> \n" +
            "\t\t\t\t\t\t1\t\t\t\t\t\t\t\t<a href=\"/index.php?mid=home&amp;page=2\">2</a> \n" +
            "\t\t\t\t\t\t\t\t<a href=\"/index.php?mid=home&amp;page=3\">3</a> \n" +
            "\t\t\t\t\t\t\t\t<a href=\"/index.php?mid=home&amp;page=4\">4</a> \n" +
            "\t\t\t\t\t\t\t\t<a href=\"/index.php?mid=home&amp;page=5\">5</a> \n" +
            "\t\t\t<a href=\"/index.php?mid=home&amp;page=11\" class=\"nextEnd\">→</a>\n" +
            "\t</div>\n" +
            "</div>\n" +
            "    \n" +
            "    </div>  </div>\n" +
            "</div>\n" +
            "</div>\t\t</div>\n" +
            "\t</div>\n" +
            "\t<div class=\"footer\">\n" +
            "\t\t<p><a href=\"http://xpressengine.com/\" target=\"_blank\">Powered by <strong>XE</strong></a></p>\n" +
            "\t</div>\n" +
            "</div><!-- ETC -->\n" +
            "<div class=\"wfsr\"></div>\n" +
            "<script src=\"/addons/captcha/captcha.min.js?20180607155533\"></script><script src=\"/addons/autolink/autolink.js?20180607155533\"></script><script src=\"/common/js/plugins/ui/jquery-ui.min.js?20180607155533\"></script><script src=\"/common/js/plugins/ui/jquery.ui.datepicker-ko.js?20180607155533\"></script><script src=\"/addons/resize_image/js/resize_image.min.js?20180607155533\"></script><script src=\"/files/cache/js_filter_compiled/842bb4196d6db6cedc6ca77e5945dab9.ko.compiled.js?20180729210506\"></script><script src=\"/files/cache/js_filter_compiled/a337ae07e7543712ba2eb4577896e894.ko.compiled.js?20180729210506\"></script></body>\n" +
            "</html>\n";
}
