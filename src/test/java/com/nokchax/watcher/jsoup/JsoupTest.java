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
        Elements valueNotMatching = document.getElementsByAttributeValueNot("key", "not matching value");
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

    @Test
    public void searchTest() {
        Elements tbody = doc.getElementsByTag("tbody");
//        System.out.println(tbody);
        Element element = tbody.get(3);

        Elements category = element.getElementsByClass("category");
        //System.out.println(category);
        //need to filter type
        // elements list (input) -> filter -> elements list (output)
        Elements matchingOwnText = doc.getElementsMatchingOwnText("픽셀");
        System.out.println(matchingOwnText);
        System.out.println();

        Elements matchingText = doc.getElementsMatchingText("픽셀");
        System.out.println(matchingText);
    }

    private static String KBD_LAB =
            "<!DOCTYPE html>\n" +
            "<html lang=\"ko\">\n" +
            "<head>\n" +
            "</head>\n" +
            "<body>\n" +
            "<div class=\"xe\">\n" +
            "<div class=\"header\">\n" +
            "<h1>\n" +
            "<a href=\"http://kbdlab.co.kr\"><img src=\"http://kbdlab.co.kr/files/attach/images/106/10f6298a1f8baa8150e181155613a5a8.png\" alt=\"logo\" border=\"0\" /></a></h1>\n" +
            "<div class=\"language\">\n" +
            "<strong title=\"ko\">한국어</strong> <button type=\"button\" class=\"toggle\"><img src=\"/layouts/xe_official/images/default/buttonLang.gif\" alt=\"Select Language\" width=\"87\" height=\"15\" /></button>\n" +
            "<ul class=\"selectLang\">\n" +
            "</ul>\n" +
            "</div>\n" +
            "<div class=\"gnb\">\n" +
            "<ul>\n" +
            "<li><a href=\"/index.php?mid=home\">KBDLAB</a>\n" +
            "</li><li class=\"active\"><a href=\"/index.php?mid=page_UgCh80\">게시판</a>\n" +
            "<ul>\n" +
            "<li><a href=\"/index.php?mid=board_cUlO13\">자유 게시판</a></li><li><a href=\"/index.php?mid=board_CDST33\">묻고 답하기</a></li><li><a href=\"/index.php?mid=board_fleamarket\">키보드 장터</a></li><li><a href=\"/index.php?mid=board_pVaE30\">이벤트</a></li><li><a href=\"/index.php?mid=board_bjxK06\">공지사항</a></li><li><a href=\"/index.php?mid=board_zoSQ99\">IT 신제품 소식</a></li><li><a href=\"/index.php?mid=board_DLSF53\">키보드랩 공헌자 목록</a></li><li><a href=\"/index.php?mid=board_mOSv08\">재능나눔</a></li></ul></li><li><a href=\"/index.php?mid=groupbuy\">공제/공구</a>\n" +
            "<ul>\n" +
            "<li><a href=\"/index.php?mid=board_gb_outside\">외부 공제/공구 소식</a></li><li><a href=\"/index.php?mid=board_gb_poll\">공제 수요 조사</a></li><li><a href=\"/index.php?mid=board_groupbuy_build\">공제 토론</a></li><li><a href=\"/index.php?mid=board_gb_do\">공제 진행</a></li></ul></li><li><a href=\"/index.php?mid=board_Lsno50\">갤러리</a>\n" +
            "</li><li><a href=\"/index.php?mid=page_Tjjg00\">키보드 공방</a>\n" +
            "<ul>\n" +
            "<li><a href=\"/index.php?mid=board_YMWT22\">공지 사항</a></li><li><a href=\"/index.php?mid=board_kbdfactorys\">키보드공장장</a></li><li><a href=\"/index.php?mid=page_tMxi68\">곤방</a></li><li><a href=\"/index.php?mid=board_JkGZ32\">괴수가면</a></li><li><a href=\"/index.php?mid=board_gqHn82\">02공방</a></li><li><a href=\"/index.php?mid=page_ZpVE14\">모닝 공방</a></li><li><a href=\"/index.php?mid=board_xVbs01\">벤공방</a></li><li><a href=\"/index.php?mid=board_FMrM24\">힝힝홍힝</a></li><li><a href=\"/index.php?mid=board_ohZp47\">곰방와</a></li><li><a href=\"/index.php?mid=board_GmvX41\">NNIH 공방</a></li><li><a href=\"/index.php?mid=board_npJs25\">PORSCHE</a></li><li><a href=\"/index.php?mid=board_VvtT35\">금벌렌더</a></li><li><a href=\"/index.php?mid=board_QKCo45\">키마럽</a></li><li><a href=\"/index.php?mid=board_wfuG55\">브라이스</a></li><li><a href=\"/index.php?mid=page_FeBB27\">휴면 공방</a></li></ul></li><li><a href=\"/index.php?mid=data\">자료실</a>\n" +
            "<ul>\n" +
            "<li><a href=\"/index.php?mid=board_layout\">키배열</a></li><li><a href=\"/index.php?mid=board_housing\">하우징</a></li><li><a href=\"/index.php?mid=board_plate\">보강판</a></li><li><a href=\"/index.php?mid=board_cir\">기판</a></li><li><a href=\"/index.php?mid=board_tune\">튜닝 &amp; 조립</a></li><li><a href=\"/index.php?mid=board_sw\">키매핑 프로그램</a></li><li><a href=\"/index.php?mid=board_rXnB23\">키맵핑 파일</a></li><li><a href=\"/index.php?mid=board_keycap\">키캡</a></li><li><a href=\"/index.php?mid=board_XAIt16\">스위치</a></li><li><a href=\"/index.php?mid=board_etc\">기타</a></li></ul></li><li><a href=\"/index.php?mid=review\">제품 리뷰</a>\n" +
            "<ul>\n" +
            "<li><a href=\"/index.php?mid=board_zqlD51\">키캡</a></li><li><a href=\"/index.php?mid=board_dAHG88\">커스텀 키보드</a></li><li><a href=\"/index.php?mid=page_uvYh18\">완성품 키보드</a></li></ul></li><li><a href=\"/index.php?mid=park\">쉼터</a>\n" +
            "<ul>\n" +
            "<li><a href=\"/index.php?mid=board_twFR55\">재미있는 글/사진</a></li><li><a href=\"/index.php?mid=rockgame\">가위바위보</a></li><li><a href=\"http://kbdlab.co.kr/index.php?module=lottery\" target=\"_blank\">즉석 복권</a></li><li><a href=\"/index.php?mid=plusad\">공익 광고</a></li></ul></li><li><a href=\"http://kbdlab.co.kr/index.php?mid=wiki\">키보드 백과사전</a>\n" +
            "<ul>\n" +
            "<li><a href=\"/index.php?mid=wiki\">키보드 백과사전</a></li><li><a href=\"/index.php?mid=board_amPd18\">토론방</a></li><li><a href=\"/index.php?mid=board_QOZy36\">이미지 저장소</a></li></ul></li><li><a href=\"/index.php?mid=lab\">연구실</a>\n" +
            "<ul>\n" +
            "<li><a href=\"/index.php?mid=board_bvJm72\">키 레이아웃 연구실</a></li><li><a href=\"/index.php?mid=board_raQz47\">키캡 디자인 연구실</a></li><li><a href=\"/index.php?mid=board_nsyk48\">하우징 디자인 연구실</a></li></ul></li></ul>\n" +
            "</div>\n" +
            "<form action=\"http://kbdlab.co.kr/\" method=\"post\" class=\"iSearch\"><input type=\"hidden\" name=\"error_return_url\" value=\"/index.php?mid=page_UgCh80\" />\n" +
            "<input type=\"hidden\" name=\"mid\" value=\"page_UgCh80\" />\n" +
            "<input type=\"hidden\" name=\"act\" value=\"IS\" />\n" +
            "<input type=\"hidden\" name=\"search_target\" value=\"title_content\" />\n" +
            "<input name=\"is_keyword\" type=\"text\" class=\"iText\" title=\"keyword\" />\n" +
            "<input type=\"image\" src=\"/layouts/xe_official/images/default/buttonSearch.gif\" alt=\"검색\" class=\"submit\" />\n" +
            "</form>\n" +
            "</div>\n" +
            "<div class=\"body\">\n" +
            "<div class=\"lnb\">\n" +
            "<div class=\"xe-widget-wrapper \" style=\"\"><div style=\"*zoom:1;padding:0px 0px 0px 0px !important;\">    <form action=\"\" method=\"post\"><input type=\"hidden\" name=\"error_return_url\" value=\"/index.php?mid=page_UgCh80\" /><input type=\"hidden\" name=\"act\" value=\"\" /><input type=\"hidden\" name=\"mid\" value=\"page_UgCh80\" /><input type=\"hidden\" name=\"vid\" value=\"\" />\n" +
            "<div ID=\"login\">\n" +
            "<div class=\"wrap-forhanbi-login\">\n" +
            "<div class=\"login_top\"><span class=\"TL-F-L\"></span><span class=\"TR-F-L\"></span></div>\n" +
            "<div class=\"login_middle\">\n" +
            "<div class=\"login_middle_on\">\n" +
            "<div id=\"logged_box\">\n" +
            "<!--포인트 /레벨 출력-->\n" +
            "<div class=\"login_message\" title=\"2019-11-05 20:49\"><span class=\"Forhanbilabel\">Level : </span><span class=\"ForhanbicurrentPoint\">8</span>&nbsp;&nbsp;&nbsp;<span class=\"Forhanbilabel\">point : </span><span class=\"ForhanbicurrentPoint\">5342</span><br/>rogue</strong>님, <br/>즐거운 하루 되세요... ^^*</div>\n" +
            "<table style=\"width:100%; height:100px;\">\n" +
            "<tr>\n" +
            "<td class=\"member_photo\">\n" +
            "<div style=\"width:80px; height:80px;background-color:white; border:5px solid #f9f9f9;margin:0 auto;\" title=\"프로필사진\">\n" +
            "<img src=\"/widgets/login_info/skins/Forhanbi_login/img/noprofile.gif\" />\n" +
            "</div>\n" +
            "</td>\n" +
            "<td id=\"menu_box\">\n" +
            "<ul>\n" +
            "<li id=\"btn_article\" title=\"작성 글 보기\"><a href=\"/index.php?mid=page_UgCh80&amp;act=dispMemberOwnDocument&amp;member_srl=5394951\"><span class=\"bgp\"></span><span>작성 글 보기</span></a></li>\n" +
            "<li id=\"btn_scrap\" title=\"스크랩 보기\"><a href=\"/index.php?mid=page_UgCh80&amp;act=dispMemberScrappedDocument&amp;member_srl=5394951\"><span class=\"bgp\"></span><span>스크랩 보기</span></a></li>\n" +
            "<li id=\"btn_folder\" title=\"저장함 보기\"><a href=\"/index.php?mid=page_UgCh80&amp;act=dispMemberSavedDocument&amp;member_srl=5394951\"><span class=\"bgp\"></span><span>저장함 보기</span></a></li>\n" +
            "</ul>\n" +
            "</td>\n" +
            "</tr>\n" +
            "</table>\n" +
            "</div>\n" +
            "</div>\n" +
            "<div class=\"logged_footer\">\n" +
            "<div class=\"l_logged_footer\"></div>\n" +
            "<div class=\"m_logged_footer\">\n" +
            "<ul id=\"logout_box\">\n" +
            "<li id=\"btn_memberinfo\" title=\"회원정보 보기\"><a href=\"/index.php?mid=page_UgCh80&amp;act=dispMemberInfo&amp;member_srl=5394951\"><span class=\"bgp png_bg\"></span></a></li>\n" +
            "<li id=\"btn_messagebox\"><a href=\"/index.php?mid=page_UgCh80&amp;act=dispCommunicationMessages&amp;member_srl=5394951\"><span class=\"bgp png_bg\" title=\"쪽지함 보기\"></span></a></li>\n" +
            "<li id=\"btn_friend\"><a href=\"/index.php?mid=page_UgCh80&amp;act=dispCommunicationFriend&amp;member_srl=5394951\"><span class=\"bgp png_bg\" title=\"친구 보기\"></span></a></li>\n" +
            "<li id=\"btn_logout\"><a href=\"/index.php?mid=page_UgCh80&amp;act=dispMemberLogout\"><span class=\"bgp png_bg\" title=\"로그아웃\"></span></a></li>\n" +
            "</ul>\n" +
            "</div>\n" +
            "<div class=\"r_logged_footer\"></div>\n" +
            "</div>\n" +
            "</div>\n" +
            "<div class=\"login_bottom\"><span class=\"BL-F-L\"></span><span class=\"BR-F-L\"></span></div>\n" +
            "</div>\n" +
            "</div>\n" +
            "</form>\n" +
            "</div></div>\n" +
            "<h2><a href=\"/index.php?mid=page_UgCh80\">게시판</a></h2><ul class=\"locNav\">\n" +
            "<li><a href=\"/index.php?mid=board_cUlO13\">자유 게시판</a>\n" +
            "</li><li><a href=\"/index.php?mid=board_CDST33\">묻고 답하기</a>\n" +
            "</li><li><a href=\"/index.php?mid=board_fleamarket\">키보드 장터</a>\n" +
            "</li><li><a href=\"/index.php?mid=board_pVaE30\">이벤트</a>\n" +
            "</li><li><a href=\"/index.php?mid=board_bjxK06\">공지사항</a>\n" +
            "</li><li><a href=\"/index.php?mid=board_zoSQ99\">IT 신제품 소식</a>\n" +
            "</li><li><a href=\"/index.php?mid=board_DLSF53\">키보드랩 공헌자 목록</a>\n" +
            "</li><li><a href=\"/index.php?mid=board_mOSv08\">재능나눔</a>\n" +
            "</li></ul><!-- 채팅창 시작 -->\n" +
            "                        <div class=\"xe-widget-wrapper \" style=\"\"><div style=\"*zoom:1;padding:0px 0px 0px 0px !important;\"><div style=\"width:100;height:550px;overflow:hidden;\">\n" +
            "<script async src=\"//client.uchat.io/uchat.js\" charset=\"utf-8\"></script>\n" +
            "<u-chat room='kbdlab' user_data='icons http%3A%2F%2Fkbdlab.co.kr%2Fmodules%2Fpoint%2Ficons%2Fkbdlab%2F8.gif|id t5394951|level 8|nick rogue|room kbdlab|time 1572955147|hash db660cfaf64e68657ee82bce11013c30' style=\"display:inline-block; width:100%; height:100%;\"></u-chat>\n" +
            "</div></div></div> \n" +
            "                        <!--    \n" +
            "                        <div class=\"xe-widget-wrapper \" style=\"\"><div style=\"*zoom:1;padding:0px 0px 0px 0px !important;\"><script type=\"text/javascript\" src=\"//uchat.co.kr/uchat.php\" charset=\"UTF-8\"></script>\n" +
            "<script type=\"text/javascript\">\n" +
            "u_chat({\n" +
            "room:\"kbdlab\"\n" +
            ", width:100, height:450, md5:\"4c540d0405a7b144faab4afac471486f\"\n" +
            ", nick:\"rogue\"\n" +
            ", mb_id:\"t5394951\"\n" +
            ", level:\"8\"\n" +
            ", icon:\"http://kbdlab.co.kr/modules/point/icons/kbdlab/8.gif\"\n" +
            ", nickcon:\"\"\n" +
            ", no_inout:true, chat_record:true, skin:1});\n" +
            "</script></div></div>   \n" +
            "                        -->\n" +
            "<!-- 채팅창 종료-->\n" +
            "                        <br/><br/>\n" +
            "<!-- 광고 시작 -->        \n" +
            "<div class=\"xe-widget-wrapper \" style=\"\"><div style=\"*zoom:1;padding:0px 0px 0px 0px !important;\"> \n" +
            "<div id=\"plusad_widget_wrap\">\n" +
            "<div class=\"plusad_point\"><a href=\"/index.php?mid=plusad&amp;act=dispPlusadlist\" title=\"광고를 등록하세요\">AD</a></div><ul id=\"plusad_widget\">\n" +
            "<li>\n" +
            "<a style=\"font-weight:bold; color:red;\" href=\"/index.php?mid=plusad&amp;act=dispPlusadlist\">진행중인 광고가 없습니다. 광고를 등록해주세요</a>\n" +
            "</li>\n" +
            " \n" +
            "</ul>\n" +
            "</div>\n" +
            " \n" +
            "<script type=\"text/javascript\">\n" +
            "jQuery(function($){\n" +
            "\n" +
            "//함수 호출\n" +
            "$(function(){\n" +
            "\n" +
            "//마우스 오버시 중지\n" +
            "move_stop = 1; //변수생성\n" +
            "$('#plusad_widget_wrap').mouseenter(function(){\n" +
            "move_stop = 0; //오버시 중지\n" +
            "}).mouseleave(function(){\n" +
            "move_stop = 1; \n" +
            "});\n" +
            "\n" +
            "var ad_length = $('#plusad_widget li').size(); //광고 목록수 구함\n" +
            "if( ad_length > 1){ //목록 1개이상일때 롤링함수 호출\n" +
            "plusad_roll(100,60000,25,0);\n" +
            "}\n" +
            "});\n" +
            "\n" +
            "\n" +
            "//롤링함수\n" +
            "function plusad_roll(speed, delay, ad_height, this_height){ //롤링속도, 롤링간격, 배너높이, 현재높이\n" +
            "\n" +
            "var ad = $('#plusad_widget');\n" +
            "var ad_list = $('#plusad_widget li:first');\n" +
            "\n" +
            "\n" +
            "if(move_stop) this_height++; //마우스 오버시 중지\n" +
            "\n" +
            "if(this_height <= ad_height){\n" +
            "\n" +
            "//스크롤함\n" +
            "$(ad).css('top',-this_height);\n" +
            "\n" +
            "//함수호출 (스크롤)\n" +
            "setTimeout(function(){\n" +
            "plusad_roll(speed, delay, ad_height, this_height);\n" +
            "},speed);\n" +
            "}else{\n" +
            "\n" +
            "//스크롤된 리스트 맨뒤로 이동\n" +
            "$(ad_list).appendTo($(ad));\n" +
            "$(ad).css('top',0);\n" +
            "\n" +
            "//함수호출 (롤링)\n" +
            "setTimeout(function(){\n" +
            "plusad_roll(speed, delay, ad_height, 0);\n" +
            "},delay);\n" +
            "\n" +
            "}\n" +
            "}\n" +
            "\n" +
            "});\n" +
            "</script>\n" +
            "</div></div>\n" +
            "<!-- 광고 종료-->\n" +
            "<!-- 좌측 메뉴에 배너 추가 시작 -->\n" +
            "<br/><br/><br/>\n" +
            "<div class=\"quickBanner\">\n" +
            "<center>\n" +
            "<!-- 메세지는 이곳에 추가 -->\n" +
            "\n" +
            "</a>\n" +
            "</center>\n" +
            "</div>\n" +
            "<!-- 좌측 메뉴에 배너 추가 끝 -->\n" +
            "</div>\n" +
            "<div class=\"content xe_content\">\n" +
            "<div class=\"xe-widget-wrapper \" style=\"float:left;width:100%;height:20px;;;;;;;;;;;;\"><div style=\"padding:0px 0px 0px 0px !important;\"><div></div></div></div><div class=\"xe-widget-wrapper \" style=\"float:left;width:100%;margin:none;padding:none;\"><div class=\"ws_nico\">\n" +
            "  <div class=\"css3pie ws_nico_title\" style=\"\">\n" +
            "            자유 게시판          <div class=\"ws_nico_arrow_border\"></div>\n" +
            "    <div class=\"ws_nico_arrow_bg\" ></div>\n" +
            "  </div>\n" +
            "  <div class=\"ws_nico_content\">\n" +
            "    <div style=\"*zoom:1;padding:0px 0px 0px 0px !important;\"><div class=\"widgetContainer\">\n" +
            "                    <table class=\"widgetTableA\" border=\"1\" cellspacing=\"0\">\n" +
            "        <tbody>\n" +
            "                <tr>\n" +
            "                <td class=\"title\">\n" +
            "                                        <a href=\"http://kbdlab.co.kr/index.php?mid=board_cUlO13&amp;category=16920\"><strong class=\"category\">정보</strong></a>\n" +
            "                        <a href=\"/index.php?mid=board_cUlO13&amp;document_srl=5975127\">OTD 360C 코르사 구매 시, 가짜를 조심하세요</a>\n" +
            "                            <em class=\"replyNum\" title=\"Replies\"><a href=\"/index.php?mid=board_cUlO13&amp;document_srl=5975127#comment\">11</a></em>\n" +
            "                                                    <span class=\"icon\"><img src=\"http://kbdlab.co.kr/modules/document/tpl/icons//new.gif\" alt=\"new\" title=\"new\" style=\"margin-right:2px;\" /><img src=\"http://kbdlab.co.kr/modules/document/tpl/icons//file.gif\" alt=\"file\" title=\"file\" style=\"margin-right:2px;\" /></span>\n" +
            "                    </td>\n" +
            "                    <td class=\"time\"><span class=\"date\">2019-11-05</span> <span class=\"hour\">16:56</span></td>\n" +
            "                    <td><a href=\"#\" onclick=\"return false;\" class=\"author member_3817349\" ><img src=\"http://kbdlab.co.kr/modules/point/icons/kbdlab/36.gif\" alt=\"[레벨:36]\" title=\"포인트:91528point (15%), 레벨:36/100\" class=\"xe_point_level_icon\" style=\"vertical-align:middle;margin-right:3px;\" />물무룩</a></td>\n" +
            "                </tr>\n" +
            "                <tr>\n" +
            "                <td class=\"title\">\n" +
            "                                        <a href=\"http://kbdlab.co.kr/index.php?mid=board_cUlO13&amp;category=16873\"><strong class=\"category\">잡담</strong></a>\n" +
            "                        <a href=\"/index.php?mid=board_cUlO13&amp;document_srl=5972502\">스텝스 컬쳐가 아니라 스텝 스컵쳐가 맞는 것 같은데</a>\n" +
            "                            <em class=\"replyNum\" title=\"Replies\"><a href=\"/index.php?mid=board_cUlO13&amp;document_srl=5972502#comment\">16</a></em>\n" +
            "                                                    <span class=\"icon\"><img src=\"http://kbdlab.co.kr/modules/document/tpl/icons//update.gif\" alt=\"update\" title=\"update\" style=\"margin-right:2px;\" /></span>\n" +
            "                    </td>\n" +
            "                    <td class=\"time\"><span class=\"date\">2019-11-03</span> <span class=\"hour\">11:26</span></td>\n" +
            "                    <td><a href=\"#\" onclick=\"return false;\" class=\"author member_5449896\" ><img src=\"http://kbdlab.co.kr/modules/point/icons/kbdlab/23.gif\" alt=\"[레벨:23]\" title=\"포인트:38728point (51%), 레벨:23/100\" class=\"xe_point_level_icon\" style=\"vertical-align:middle;margin-right:3px;\" />옥현봉</a></td>\n" +
            "                </tr>\n" +
            "                <tr>\n" +
            "                <td class=\"title\">\n" +
            "                                        <a href=\"http://kbdlab.co.kr/index.php?mid=board_cUlO13&amp;category=16873\"><strong class=\"category\">잡담</strong></a>\n" +
            "                        <a href=\"/index.php?mid=board_cUlO13&amp;document_srl=5967815\">레오폴드 FC660M 청축 타건영상</a>\n" +
            "                            <em class=\"replyNum\" title=\"Replies\"><a href=\"/index.php?mid=board_cUlO13&amp;document_srl=5967815#comment\">2</a></em>\n" +
            "                                                    <span class=\"icon\"></span>\n" +
            "                    </td>\n" +
            "                    <td class=\"time\"><span class=\"date\">2019-10-29</span> <span class=\"hour\">23:32</span></td>\n" +
            "                    <td><a href=\"#\" onclick=\"return false;\" class=\"author member_4362470\" ><img src=\"http://kbdlab.co.kr/modules/point/icons/kbdlab/21.gif\" alt=\"[레벨:21]\" title=\"포인트:31523point (21%), 레벨:21/100\" class=\"xe_point_level_icon\" style=\"vertical-align:middle;margin-right:3px;\" />아오기리</a></td>\n" +
            "                </tr>\n" +
            "                <tr>\n" +
            "                <td class=\"title\">\n" +
            "                                        <a href=\"http://kbdlab.co.kr/index.php?mid=board_cUlO13&amp;category=16873\"><strong class=\"category\">잡담</strong></a>\n" +
            "                        <a href=\"/index.php?mid=board_cUlO13&amp;document_srl=5964629\">안녕하세요. 금벌레 입니다.</a>\n" +
            "                            <em class=\"replyNum\" title=\"Replies\"><a href=\"/index.php?mid=board_cUlO13&amp;document_srl=5964629#comment\">18</a></em>\n" +
            "                                                    <span class=\"icon\"></span>\n" +
            "                    </td>\n" +
            "                    <td class=\"time\"><span class=\"date\">2019-10-27</span> <span class=\"hour\">07:29</span></td>\n" +
            "                    <td><a href=\"#\" onclick=\"return false;\" class=\"author member_4107527\" ><img src=\"http://kbdlab.co.kr/modules/point/icons/kbdlab/32.gif\" alt=\"[레벨:32]\" title=\"포인트:74361point (58%), 레벨:32/100\" class=\"xe_point_level_icon\" style=\"vertical-align:middle;margin-right:3px;\" />금벌레</a></td>\n" +
            "                </tr>\n" +
            "                <tr>\n" +
            "                <td class=\"title\">\n" +
            "                                        <a href=\"http://kbdlab.co.kr/index.php?mid=board_cUlO13&amp;category=16920\"><strong class=\"category\">정보</strong></a>\n" +
            "                        <a href=\"/index.php?mid=board_cUlO13&amp;document_srl=5963655\">구형 키보드 황변제거입니다.</a>\n" +
            "                            <em class=\"replyNum\" title=\"Replies\"><a href=\"/index.php?mid=board_cUlO13&amp;document_srl=5963655#comment\">26</a></em>\n" +
            "                                                    <span class=\"icon\"><img src=\"http://kbdlab.co.kr/modules/document/tpl/icons//file.gif\" alt=\"file\" title=\"file\" style=\"margin-right:2px;\" /></span>\n" +
            "                    </td>\n" +
            "                    <td class=\"time\"><span class=\"date\">2019-10-26</span> <span class=\"hour\">16:48</span></td>\n" +
            "                    <td><a href=\"#\" onclick=\"return false;\" class=\"author member_5464855\" ><img src=\"http://kbdlab.co.kr/modules/point/icons/kbdlab/20.gif\" alt=\"[레벨:20]\" title=\"포인트:30362point (82%), 레벨:20/100\" class=\"xe_point_level_icon\" style=\"vertical-align:middle;margin-right:3px;\" />2502</a></td>\n" +
            "                </tr>\n" +
            "                </tbody>\n" +
            "    </table>\n" +
            "        </div>\n" +
            "</div>  </div>\n" +
            "</div>\n" +
            "</div><div class=\"xe-widget-wrapper \" style=\"float:left;width:100%;height:20px;;;;;;;;;;;;\"><div style=\"padding:0px 0px 0px 0px !important;\"><div></div></div></div><div class=\"xe-widget-wrapper \" style=\"float:left;width:100%;margin:none;padding:none;\"><div class=\"ws_nico\">\n" +
            "  <div class=\"css3pie ws_nico_title\" style=\"\">\n" +
            "            묻고 답하기          <div class=\"ws_nico_arrow_border\"></div>\n" +
            "    <div class=\"ws_nico_arrow_bg\" ></div>\n" +
            "  </div>\n" +
            "  <div class=\"ws_nico_content\">\n" +
            "    <div style=\"*zoom:1;padding:0px 0px 0px 0px !important;\"><div class=\"widgetContainer\">\n" +
            "                    <table class=\"widgetTableA\" border=\"1\" cellspacing=\"0\">\n" +
            "        <tbody>\n" +
            "                <tr>\n" +
            "                <td class=\"title\">\n" +
            "                                        <a href=\"http://kbdlab.co.kr/index.php?mid=board_CDST33&amp;category=52002\"><strong class=\"category\">커스텀</strong></a>\n" +
            "                        <a href=\"/index.php?mid=board_CDST33&amp;document_srl=5975309\">60% 키보드 하우징</a>\n" +
            "                            <em class=\"replyNum\" title=\"Replies\"><a href=\"/index.php?mid=board_CDST33&amp;document_srl=5975309#comment\">1</a></em>\n" +
            "                                                    <span class=\"icon\"><img src=\"http://kbdlab.co.kr/modules/document/tpl/icons//new.gif\" alt=\"new\" title=\"new\" style=\"margin-right:2px;\" /></span>\n" +
            "                    </td>\n" +
            "                    <td class=\"time\"><span class=\"date\">2019-11-05</span> <span class=\"hour\">19:55</span></td>\n" +
            "                    <td><a href=\"#\" onclick=\"return false;\" class=\"author member_5936017\" ><img src=\"http://kbdlab.co.kr/modules/point/icons/kbdlab/5.gif\" alt=\"[레벨:5]\" title=\"포인트:1783point (4%), 레벨:5/100\" class=\"xe_point_level_icon\" style=\"vertical-align:middle;margin-right:3px;\" />manaorme</a></td>\n" +
            "                </tr>\n" +
            "                <tr>\n" +
            "                <td class=\"title\">\n" +
            "                                        <a href=\"http://kbdlab.co.kr/index.php?mid=board_CDST33&amp;category=52016\"><strong class=\"category\">스위치</strong></a>\n" +
            "                        <a href=\"/index.php?mid=board_CDST33&amp;document_srl=5975098\">욕판다 스위치 문의드려요</a>\n" +
            "                            <em class=\"replyNum\" title=\"Replies\"><a href=\"/index.php?mid=board_CDST33&amp;document_srl=5975098#comment\">2</a></em>\n" +
            "                                                    <span class=\"icon\"><img src=\"http://kbdlab.co.kr/modules/document/tpl/icons//new.gif\" alt=\"new\" title=\"new\" style=\"margin-right:2px;\" /></span>\n" +
            "                    </td>\n" +
            "                    <td class=\"time\"><span class=\"date\">2019-11-05</span> <span class=\"hour\">16:15</span></td>\n" +
            "                    <td><a href=\"#\" onclick=\"return false;\" class=\"author member_5724544\" ><img src=\"http://kbdlab.co.kr/modules/point/icons/kbdlab/6.gif\" alt=\"[레벨:6]\" title=\"포인트:3199point (74%), 레벨:6/100\" class=\"xe_point_level_icon\" style=\"vertical-align:middle;margin-right:3px;\" />찐탱</a></td>\n" +
            "                </tr>\n" +
            "                <tr>\n" +
            "                <td class=\"title\">\n" +
            "                                        <a href=\"http://kbdlab.co.kr/index.php?mid=board_CDST33&amp;category=52003\"><strong class=\"category\">기성품</strong></a>\n" +
            "                        <a href=\"/index.php?mid=board_CDST33&amp;document_srl=5974519\">키보드 맨아래줄이 하나 건너 하나씩 인식이 안되네요...?</a>\n" +
            "                            <em class=\"replyNum\" title=\"Replies\"><a href=\"/index.php?mid=board_CDST33&amp;document_srl=5974519#comment\">1</a></em>\n" +
            "                                                    <span class=\"icon\"><img src=\"http://kbdlab.co.kr/modules/document/tpl/icons//new.gif\" alt=\"new\" title=\"new\" style=\"margin-right:2px;\" /></span>\n" +
            "                    </td>\n" +
            "                    <td class=\"time\"><span class=\"date\">2019-11-05</span> <span class=\"hour\">02:35</span></td>\n" +
            "                    <td><a href=\"#\" onclick=\"return false;\" class=\"author member_5659066\" ><img src=\"http://kbdlab.co.kr/modules/point/icons/kbdlab/7.gif\" alt=\"[레벨:7]\" title=\"포인트:3831point (38%), 레벨:7/100\" class=\"xe_point_level_icon\" style=\"vertical-align:middle;margin-right:3px;\" />Dogak</a></td>\n" +
            "                </tr>\n" +
            "                <tr>\n" +
            "                <td class=\"title\">\n" +
            "                                        <a href=\"http://kbdlab.co.kr/index.php?mid=board_CDST33&amp;category=52016\"><strong class=\"category\">스위치</strong></a>\n" +
            "                        <a href=\"/index.php?mid=board_CDST33&amp;document_srl=5974312\">홀리판다 만드는 법</a>\n" +
            "                            <em class=\"replyNum\" title=\"Replies\"><a href=\"/index.php?mid=board_CDST33&amp;document_srl=5974312#comment\">2</a></em>\n" +
            "                                                    <span class=\"icon\"><img src=\"http://kbdlab.co.kr/modules/document/tpl/icons//new.gif\" alt=\"new\" title=\"new\" style=\"margin-right:2px;\" /></span>\n" +
            "                    </td>\n" +
            "                    <td class=\"time\"><span class=\"date\">2019-11-04</span> <span class=\"hour\">22:18</span></td>\n" +
            "                    <td><a href=\"#\" onclick=\"return false;\" class=\"author member_5430741\" ><img src=\"http://kbdlab.co.kr/modules/point/icons/kbdlab/10.gif\" alt=\"[레벨:10]\" title=\"포인트:8367point (92%), 레벨:10/100\" class=\"xe_point_level_icon\" style=\"vertical-align:middle;margin-right:3px;\" />산과들의나무</a></td>\n" +
            "                </tr>\n" +
            "                <tr>\n" +
            "                <td class=\"title\">\n" +
            "                                        <a href=\"http://kbdlab.co.kr/index.php?mid=board_CDST33&amp;category=52002\"><strong class=\"category\">커스텀</strong></a>\n" +
            "                        <a href=\"/index.php?mid=board_CDST33&amp;document_srl=5974039\">tx87se 에 이퀄츠 기판 적용 문의</a>\n" +
            "                            <em class=\"replyNum\" title=\"Replies\"><a href=\"/index.php?mid=board_CDST33&amp;document_srl=5974039#comment\">2</a></em>\n" +
            "                                                    <span class=\"icon\"></span>\n" +
            "                    </td>\n" +
            "                    <td class=\"time\"><span class=\"date\">2019-11-04</span> <span class=\"hour\">17:15</span></td>\n" +
            "                    <td><a href=\"#\" onclick=\"return false;\" class=\"author member_3769633\" ><img src=\"http://kbdlab.co.kr/modules/point/icons/kbdlab/23.gif\" alt=\"[레벨:23]\" title=\"포인트:39183point (65%), 레벨:23/100\" class=\"xe_point_level_icon\" style=\"vertical-align:middle;margin-right:3px;\" />iple</a></td>\n" +
            "                </tr>\n" +
            "                </tbody>\n" +
            "    </table>\n" +
            "        </div>\n" +
            "</div>  </div>\n" +
            "</div>\n" +
            "</div><div class=\"xe-widget-wrapper \" style=\"float:left;width:100%;height:20px;;;;;;;;;;;;\"><div style=\"padding:0px 0px 0px 0px !important;\"><div></div></div></div><div class=\"xe-widget-wrapper \" style=\"float:left;width:100%;margin:none;padding:none;\"><div class=\"ws_nico\">\n" +
            "  <div class=\"css3pie ws_nico_title\" style=\"\">\n" +
            "            장터          <div class=\"ws_nico_arrow_border\"></div>\n" +
            "    <div class=\"ws_nico_arrow_bg\" ></div>\n" +
            "  </div>\n" +
            "  <div class=\"ws_nico_content\">\n" +
            "    <div style=\"*zoom:1;padding:0px 0px 0px 0px !important;\"><div class=\"widgetContainer\">\n" +
            "                    <table class=\"widgetTableA\" border=\"1\" cellspacing=\"0\">\n" +
            "        <tbody>\n" +
            "                <tr>\n" +
            "                <td class=\"title\">\n" +
            "                                        <a href=\"http://kbdlab.co.kr/index.php?mid=board_fleamarket&amp;category=16119\"><strong class=\"category\">판매</strong></a>\n" +
            "                        <a href=\"/index.php?mid=board_fleamarket&amp;document_srl=5975224\">팝니다.</a>\n" +
            "                                                    <span class=\"icon\"><img src=\"http://kbdlab.co.kr/modules/document/tpl/icons//new.gif\" alt=\"new\" title=\"new\" style=\"margin-right:2px;\" /><img src=\"http://kbdlab.co.kr/modules/document/tpl/icons//file.gif\" alt=\"file\" title=\"file\" style=\"margin-right:2px;\" /></span>\n" +
            "                    </td>\n" +
            "                    <td class=\"time\"><span class=\"date\">2019-11-05</span> <span class=\"hour\">17:36</span></td>\n" +
            "                    <td><a href=\"#\" onclick=\"return false;\" class=\"author member_5901116\" ><img src=\"http://kbdlab.co.kr/modules/point/icons/kbdlab/1.gif\" alt=\"[레벨:1]\" title=\"포인트:245point (83%), 레벨:1/100\" class=\"xe_point_level_icon\" style=\"vertical-align:middle;margin-right:3px;\" />다정이키보드</a></td>\n" +
            "                </tr>\n" +
            "                <tr>\n" +
            "                <td class=\"title\">\n" +
            "                                        <a href=\"http://kbdlab.co.kr/index.php?mid=board_fleamarket&amp;category=16119\"><strong class=\"category\">판매</strong></a>\n" +
            "                        <a href=\"/index.php?mid=board_fleamarket&amp;document_srl=5975144\">돌치TKL 테프론코팅(블랙펄) 팝니다.</a>\n" +
            "                                                    <span class=\"icon\"><img src=\"http://kbdlab.co.kr/modules/document/tpl/icons//new.gif\" alt=\"new\" title=\"new\" style=\"margin-right:2px;\" /></span>\n" +
            "                    </td>\n" +
            "                    <td class=\"time\"><span class=\"date\">2019-11-05</span> <span class=\"hour\">16:55</span></td>\n" +
            "                    <td><a href=\"#\" onclick=\"return false;\" class=\"author member_5622435\" ><img src=\"http://kbdlab.co.kr/modules/point/icons/kbdlab/11.gif\" alt=\"[레벨:11]\" title=\"포인트:8882point (25%), 레벨:11/100\" class=\"xe_point_level_icon\" style=\"vertical-align:middle;margin-right:3px;\" />타자왕통키</a></td>\n" +
            "                </tr>\n" +
            "                <tr>\n" +
            "                <td class=\"title\">\n" +
            "                                        <a href=\"http://kbdlab.co.kr/index.php?mid=board_fleamarket&amp;category=16119\"><strong class=\"category\">판매</strong></a>\n" +
            "                        <a href=\"/index.php?mid=board_fleamarket&amp;document_srl=5975113\">[커스텀 키보드(Diablo 인디고 블루)]</a>\n" +
            "                                                    <span class=\"icon\"><img src=\"http://kbdlab.co.kr/modules/document/tpl/icons//new.gif\" alt=\"new\" title=\"new\" style=\"margin-right:2px;\" /><img src=\"http://kbdlab.co.kr/modules/document/tpl/icons//file.gif\" alt=\"file\" title=\"file\" style=\"margin-right:2px;\" /></span>\n" +
            "                    </td>\n" +
            "                    <td class=\"time\"><span class=\"date\">2019-11-05</span> <span class=\"hour\">16:51</span></td>\n" +
            "                    <td><a href=\"#\" onclick=\"return false;\" class=\"author member_5430741\" ><img src=\"http://kbdlab.co.kr/modules/point/icons/kbdlab/10.gif\" alt=\"[레벨:10]\" title=\"포인트:8367point (92%), 레벨:10/100\" class=\"xe_point_level_icon\" style=\"vertical-align:middle;margin-right:3px;\" />산과들의나무</a></td>\n" +
            "                </tr>\n" +
            "                <tr>\n" +
            "                <td class=\"title\">\n" +
            "                                        <a href=\"http://kbdlab.co.kr/index.php?mid=board_fleamarket&amp;category=16125\"><strong class=\"category\">구매</strong></a>\n" +
            "                        <a href=\"/index.php?mid=board_fleamarket&amp;document_srl=5975112\">미조립 키보드구매합니다</a>\n" +
            "                                                    <span class=\"icon\"><img src=\"http://kbdlab.co.kr/modules/document/tpl/icons//new.gif\" alt=\"new\" title=\"new\" style=\"margin-right:2px;\" /></span>\n" +
            "                    </td>\n" +
            "                    <td class=\"time\"><span class=\"date\">2019-11-05</span> <span class=\"hour\">16:48</span></td>\n" +
            "                    <td><a href=\"#\" onclick=\"return false;\" class=\"author member_5627006\" ><img src=\"http://kbdlab.co.kr/modules/point/icons/kbdlab/6.gif\" alt=\"[레벨:6]\" title=\"포인트:2626point (11%), 레벨:6/100\" class=\"xe_point_level_icon\" style=\"vertical-align:middle;margin-right:3px;\" />valain.</a></td>\n" +
            "                </tr>\n" +
            "                <tr>\n" +
            "                <td class=\"title\">\n" +
            "                                        <a href=\"http://kbdlab.co.kr/index.php?mid=board_fleamarket&amp;category=16119\"><strong class=\"category\">판매</strong></a>\n" +
            "                        <a href=\"/index.php?mid=board_fleamarket&amp;document_srl=5975006\">아크릴 키보드 여러대 판매합니다.</a>\n" +
            "                            <em class=\"replyNum\" title=\"Replies\"><a href=\"/index.php?mid=board_fleamarket&amp;document_srl=5975006#comment\">3</a></em>\n" +
            "                                                    <span class=\"icon\"><img src=\"http://kbdlab.co.kr/modules/document/tpl/icons//new.gif\" alt=\"new\" title=\"new\" style=\"margin-right:2px;\" /><img src=\"http://kbdlab.co.kr/modules/document/tpl/icons//file.gif\" alt=\"file\" title=\"file\" style=\"margin-right:2px;\" /></span>\n" +
            "                    </td>\n" +
            "                    <td class=\"time\"><span class=\"date\">2019-11-05</span> <span class=\"hour\">15:21</span></td>\n" +
            "                    <td><a href=\"#\" onclick=\"return false;\" class=\"author member_238436\" ><img src=\"http://kbdlab.co.kr/modules/point/icons/kbdlab/44.gif\" alt=\"[레벨:44]\" title=\"포인트:141027point (88%), 레벨:44/100\" class=\"xe_point_level_icon\" style=\"vertical-align:middle;margin-right:3px;\" />.benkei.</a></td>\n" +
            "                </tr>\n" +
            "                </tbody>\n" +
            "    </table>\n" +
            "        </div>\n" +
            "</div>  </div>\n" +
            "</div>\n" +
            "</div><div class=\"xe-widget-wrapper \" style=\"float:left;width:100%;height:20px;;;\"><div style=\"padding:0px 0px 0px 0px !important;\"><div></div></div></div><div class=\"xe-widget-wrapper \" style=\"float:left;width:100%;margin:none;padding:none;\"><div class=\"ws_nico\">\n" +
            "  <div class=\"css3pie ws_nico_title\" style=\"\">\n" +
            "            재능나눔          <div class=\"ws_nico_arrow_border\"></div>\n" +
            "    <div class=\"ws_nico_arrow_bg\" ></div>\n" +
            "  </div>\n" +
            "  <div class=\"ws_nico_content\">\n" +
            "    <div style=\"*zoom:1;padding:0px 0px 0px 0px !important;\"><div class=\"widgetContainer\">\n" +
            "                    <table class=\"widgetTableA\" border=\"1\" cellspacing=\"0\">\n" +
            "        <tbody>\n" +
            "                <tr>\n" +
            "                <td class=\"title\">\n" +
            "                                        <a href=\"http://kbdlab.co.kr/index.php?mid=board_mOSv08&amp;category=5487117\"><strong class=\"category\">uppereal의 픽셀아트</strong></a>\n" +
            "                        <a href=\"/index.php?mid=board_mOSv08&amp;document_srl=5955226\">안녕하세요. 픽셀아트 부탁드립니다.</a>\n" +
            "                                                    <span class=\"icon\"><img src=\"http://kbdlab.co.kr/modules/document/tpl/icons//file.gif\" alt=\"file\" title=\"file\" style=\"margin-right:2px;\" /></span>\n" +
            "                    </td>\n" +
            "                    <td class=\"time\"><span class=\"date\">2019-10-19</span> <span class=\"hour\">05:25</span></td>\n" +
            "                    <td><a href=\"#\" onclick=\"return false;\" class=\"author member_5700340\" ><img src=\"http://kbdlab.co.kr/modules/point/icons/kbdlab/14.gif\" alt=\"[레벨:14]\" title=\"포인트:15487point (87%), 레벨:14/100\" class=\"xe_point_level_icon\" style=\"vertical-align:middle;margin-right:3px;\" />홍설</a></td>\n" +
            "                </tr>\n" +
            "                <tr>\n" +
            "                <td class=\"title\">\n" +
            "                                        <a href=\"http://kbdlab.co.kr/index.php?mid=board_mOSv08&amp;category=5487117\"><strong class=\"category\">uppereal의 픽셀아트</strong></a>\n" +
            "                        <a href=\"/index.php?mid=board_mOSv08&amp;document_srl=5927506\">픽셀아트 부탁드립니다~</a>\n" +
            "                                                    <span class=\"icon\"><img src=\"http://kbdlab.co.kr/modules/document/tpl/icons//file.gif\" alt=\"file\" title=\"file\" style=\"margin-right:2px;\" /></span>\n" +
            "                    </td>\n" +
            "                    <td class=\"time\"><span class=\"date\">2019-09-22</span> <span class=\"hour\">13:14</span></td>\n" +
            "                    <td><a href=\"#\" onclick=\"return false;\" class=\"author member_5020146\" ><img src=\"http://kbdlab.co.kr/modules/point/icons/kbdlab/42.gif\" alt=\"[레벨:42]\" title=\"포인트:125588point (35%), 레벨:42/100\" class=\"xe_point_level_icon\" style=\"vertical-align:middle;margin-right:3px;\" />홍들홍들</a></td>\n" +
            "                </tr>\n" +
            "                <tr>\n" +
            "                <td class=\"title\">\n" +
            "                                        <a href=\"http://kbdlab.co.kr/index.php?mid=board_mOSv08&amp;category=5487117\"><strong class=\"category\">uppereal의 픽셀아트</strong></a>\n" +
            "                        <a href=\"/index.php?mid=board_mOSv08&amp;document_srl=5926643\">안녕하세요. 픽셀아트 요청드립니다!</a>\n" +
            "                                                    <span class=\"icon\"><img src=\"http://kbdlab.co.kr/modules/document/tpl/icons//file.gif\" alt=\"file\" title=\"file\" style=\"margin-right:2px;\" /></span>\n" +
            "                    </td>\n" +
            "                    <td class=\"time\"><span class=\"date\">2019-09-21</span> <span class=\"hour\">19:37</span></td>\n" +
            "                    <td><a href=\"#\" onclick=\"return false;\" class=\"author member_5668615\" ><img src=\"http://kbdlab.co.kr/modules/point/icons/kbdlab/2.gif\" alt=\"[레벨:2]\" title=\"포인트:394point (32%), 레벨:2/100\" class=\"xe_point_level_icon\" style=\"vertical-align:middle;margin-right:3px;\" />hoz3</a></td>\n" +
            "                </tr>\n" +
            "                <tr>\n" +
            "                <td class=\"title\">\n" +
            "                                        <a href=\"http://kbdlab.co.kr/index.php?mid=board_mOSv08&amp;category=5487117\"><strong class=\"category\">uppereal의 픽셀아트</strong></a>\n" +
            "                        <a href=\"/index.php?mid=board_mOSv08&amp;document_srl=5879610\">안녕하세요 픽셀아트 신청해봅니다!!</a>\n" +
            "                                                    <span class=\"icon\"><img src=\"http://kbdlab.co.kr/modules/document/tpl/icons//file.gif\" alt=\"file\" title=\"file\" style=\"margin-right:2px;\" /></span>\n" +
            "                    </td>\n" +
            "                    <td class=\"time\"><span class=\"date\">2019-08-09</span> <span class=\"hour\">01:47</span></td>\n" +
            "                    <td><a href=\"#\" onclick=\"return false;\" class=\"author member_3880167\" ><img src=\"http://kbdlab.co.kr/modules/point/icons/kbdlab/21.gif\" alt=\"[레벨:21]\" title=\"포인트:32759point (62%), 레벨:21/100\" class=\"xe_point_level_icon\" style=\"vertical-align:middle;margin-right:3px;\" />포도</a></td>\n" +
            "                </tr>\n" +
            "                <tr>\n" +
            "                <td class=\"title\">\n" +
            "                                        <a href=\"http://kbdlab.co.kr/index.php?mid=board_mOSv08&amp;category=5487117\"><strong class=\"category\">uppereal의 픽셀아트</strong></a>\n" +
            "                        <a href=\"/index.php?mid=board_mOSv08&amp;document_srl=5861664\">픽셀아트 부탁드려봅니다.</a>\n" +
            "                                                    <span class=\"icon\"><img src=\"http://kbdlab.co.kr/modules/document/tpl/icons//file.gif\" alt=\"file\" title=\"file\" style=\"margin-right:2px;\" /></span>\n" +
            "                    </td>\n" +
            "                    <td class=\"time\"><span class=\"date\">2019-07-23</span> <span class=\"hour\">21:41</span></td>\n" +
            "                    <td><a href=\"#\" onclick=\"return false;\" class=\"author member_5391571\" ><img src=\"http://kbdlab.co.kr/modules/point/icons/kbdlab/19.gif\" alt=\"[레벨:19]\" title=\"포인트:27989point (99%), 레벨:19/100\" class=\"xe_point_level_icon\" style=\"vertical-align:middle;margin-right:3px;\" />글레어</a></td>\n" +
            "                </tr>\n" +
            "                </tbody>\n" +
            "    </table>\n" +
            "        </div>\n" +
            "</div>  </div>\n" +
            "</div>\n" +
            "</div></div>\n" +
            "</div>\n" +
            "<div class=\"footer\">\n" +
            "<p><a href=\"http://xpressengine.com/\" target=\"_blank\">Powered by <strong>XE</strong></a></p>\n" +
            "</div>\n" +
            "</div><!-- ETC -->\n" +
            "<div class=\"wfsr\"></div>\n" +
            "<script src=\"/addons/captcha/captcha.min.js?20180607155533\"></script><script src=\"/addons/autolink/autolink.js?20180607155533\"></script><script src=\"/common/js/plugins/ui/jquery-ui.min.js?20180607155533\"></script><script src=\"/common/js/plugins/ui/jquery.ui.datepicker-ko.js?20180607155533\"></script><script src=\"/addons/resize_image/js/resize_image.min.js?20180607155533\"></script><script src=\"/files/cache/js_filter_compiled/e8e83631bc082571a2925f000c433abe.ko.compiled.js?20180729210509\"></script><script src=\"/modules/ncenterlite/tpl/js/ncenterlite.js?20180709090035\"></script></body>\n" +
            "</html>\n";
}