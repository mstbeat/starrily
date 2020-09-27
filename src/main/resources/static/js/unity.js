/**
 * 共通のイベント
 */
jQuery(function($) {
	/* IE判定 */
	//閲覧しているブラウザの情報（ユーザーエージェント）を取得
	var ua = window.navigator.userAgent;
	//IE判定(IE11とIE10以前)、アラート表示。
	if(ua.indexOf('Trident') != -1 || ua.indexOf('MSIE') != -1){
	  alert('お使いのブラウザはStarrilyの閲覧推奨環境ではありません。\nウェブサイトが正しく表示されない、動作しない等の現象が起こる場合がありますので予めご了承ください。\nchromeまたはEdgeブラウザのご利用をおすすめいたします。');
	}

  // 削除ボタンの確認メッセージ
   $('.delete').click(function(){
    return confirm('このユーザーを削除してよろしいですか？');
  });

});

// 削除ボタンの確認メッセージ
$('.deleteproject').click(function(){
	return confirm('この案件を削除してよろしいですか？');
});

    /* テキストエリアの初期設定. */
  // 最小値height:100pxで指定
  $("#textareaHight").height(30);
  $("#textareaHight").css("lineHeight","20px");

  // テキストエリアの高さ自動調節
  $("#textareaHight").on("autoheight", function(evt) {
    var target = evt.target;
    if (target.scrollHeight > target.offsetHeight) {
      // スクロールする高さをheightに指定
      $(target).height(target.scrollHeight);
    }
    else {
      // lineHeight値を数値で取得
      var lineHeight = Number($(target).css("lineHeight").split("px")[0]);

      while (true) {
        // lineHeightずつheightを小さくする
        $(target).height($(target).height() - lineHeight);
        // スクロールする高さが対象セレクタの高さより大きくなるまで繰り返す
        if (target.scrollHeight > target.offsetHeight) {
          $(target).height(target.scrollHeight);
          break;
        }
      }
    }
  });

  //画面を読み込んだ時、子画面にチェックがあれば担当フェーズを表示する
  $(document).ready(function(){
        $("#textareaHight").trigger('autoheight');
  });

  // まだ機能が完成していないところでアラートを表示する
  function stop() {
	  alert("この機能はまだ実装されていません。");
  }
