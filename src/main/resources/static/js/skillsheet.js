let dbVerPulArrayNum = 0;
// add_db2.addEventListener()メソッドが呼ばれた回数
let dbArrayNum = 0;
// add_fw.addEventListener()メソッドが呼ばれた回数
let fwNwArrayNum = 0;
// add_os.addEventListener()メソッドが呼ばれた回数
let osVerPulArrayNum = 0 ;
// add_os2.addEventListener()メソッドが呼ばれた回数
let osArrayNum = 0;
// add_lang.addEventListener()メソッドが呼ばれた回数
let languageVerPulArrayNum = 0;
//add_lang2.addEventListener()メソッドが呼ばれた回数
let languageArrayNum = 0;
//add_other.addEventListener()メソッドが呼ばれた回数
let otherArrayNum = 0;

$(function() {
  var $children = $('.children1');
  var original = $children.html();

  $('.parent1').change(function() {
    var val1 = $(this).val();

    $children.html(original).find('option').each(function() {
      var val2 = $(this).data('val');
      if (val1 != val2) {
        $(this).not('optgroup,.msg1').remove();
      }
    });
    if ($(this).val() === '') {
      $children.attr('disabled', 'disabled');
    } else {
      $children.removeAttr('disabled');
    }
  });
});

$(function() {
  var $children = $('.children2');
  var original = $children.html();

  $('.parent2').change(function() {
    var val1 = $(this).val();

    $children.html(original).find('option').each(function() {
      var val2 = $(this).data('val');
      if (val1 != val2) {
        $(this).not('optgroup,.msg2').remove();
      }
    });

    if ($(this).val() === '') {
      $children.attr('disabled', 'disabled');
    } else {
      $children.removeAttr('disabled');
    }
  });
});

$(function() {
  var $children = $('.children3');
  var original = $children.html();

  $('.parent3').change(function() {
    var val1 = $(this).val();

    $children.html(original).find('option').each(function() {
      var val2 = $(this).data('val');
      if (val1 != val2) {
        $(this).not('optgroup,.msg3').remove();
      }
    });

    if ($(this).val() === '') {
      $children.attr('disabled', 'disabled');
    } else {
      $children.removeAttr('disabled');
    }

  });
});

$(function() {
  var $children = $('.children4');
  var original = $children.html();

  $('.parent4').change(function() {
    var val1 = $(this).val();

    $children.html(original).find('option').each(function() {
      var val2 = $(this).data('val');
      if (val1 != val2) {
        $(this).not('optgroup,.msg4').remove();
      }
    });

    if ($(this).val() === '') {
      $children.attr('disabled', 'disabled');
    } else {
      $children.removeAttr('disabled');
    }

  });
});

$(function() {
  var $children = $('.children5');
  var original = $children.html();

  $('.parent5').change(function() {
    var val1 = $(this).val();

    $children.html(original).find('option').each(function() {
      var val2 = $(this).data('val');
      if (val1 != val2) {
        $(this).not('optgroup,.msg5').remove();
      }
    });

    if ($(this).val() === '') {
      $children.attr('disabled', 'disabled');
    } else {
      $children.removeAttr('disabled');
    }

  });
});

/**
 * スキルシート画面関係のイベント
 */
jQuery(function($) {
  // inputを増やす動きを付ける
  // エンジニア検索画面で、追加ボタンを押した時の動き
  // 検索欄を増やす
  $(document).on("click", "#add", function() {
    $(this).parent().append(
      '<p>'+
      '<select class="widthbox">'+
          '<option value="">項目を選択してください</option>'+
          '<option value="">OS</option>'+
          '<option value="">NW/FW</option>'+
          '<option value="">DB</option>'+
          '<option value="">言語</option>'+
        '</select>'+
        '<span> </span>'+
        '<select  class="widthbox">'+
           '<option value="">項目の内容を選択してください</option>'+
           '<option value="">Springboot</option>'+
           '<option value="">Java</option>'+
          '<option value="">Linux</option>'+
          ' <option value="">PHP</option></option>'+
           '<option value="">Excel</option>'+
         '</select>'+
         '<span> </span>'+
        '<input class="widthbox inputwidth" type="text" placeholder="バージョン">'+
         '<span> </span>'+
        '<select  class="widthbox">'+
           '<option value="">経験年数を選択してください</option>'+
           '<option value="">1年以内</option>'+
           '<option value="">1年以上</option>'+
           '<option value="">3年以上</option>'+
           '<option value="">5年以上</option></option>'+
           '<option value="">10年以上</option>'+
         '</select>'+
      '<input type="button" class="del delrelative">'+
      '</p>');
});

  //add_dbクラスのついたボタンが押されたとき、DB欄を増やす
  // セレクトボックス＋テキストボックス＋削除ボタン。を挿入する
  // idが「add_db」の要素を取得
  let add_db = document.getElementById("add_db");

  add_db.addEventListener("click", function(){
	 //idが「box_db」の要素を取得
	 let boxes = document.getElementById("box_db");
	 //「boxes」の要素を複製（コピー）
	 let clone = boxes.cloneNode(true);
	 // add_db.addEventListener()メソッドが呼ばれた回数
	 dbVerPulArrayNum++;
	 // メソッド呼ばれた回数取得 クローンするたびIDにプラス1ずつ足していく
	 // 登録ボタンを押しておらず、尚且つ削除もしていない場合
	 if (sessionStorage.getItem("dbVerPulArrayNum") == null
			 && sessionStorage.getItem("dbPulDelete") == null
			 || sessionStorage.getItem("dbVerPulArrayNum") == 0
			 && sessionStorage.getItem("dbPulDelete") == null) {
		 // cloneしたHTMLのidのdbPulArrayにメソッドが呼ばれるたびプラス1ずつ足していく
		 $(clone).find("#dbPulArray").attr("id", "dbPulArray" + dbVerPulArrayNum);
		 // cloneしたHTMLのidのdbVerPulArrayにメソッドが呼ばれるたびプラス1ずつ足していく
		 $(clone).find("#dbVerPulArray").attr("id", "dbVerPulArray" + dbVerPulArrayNum);
	 // 登録ボタンを押しておらず、尚且つ削除している場合
	 } else if (sessionStorage.getItem("dbVerPulArrayNum") == null
			 && Math.sign(sessionStorage.getItem("dbPulDelete")) == 1) {
		 // cloneしたHTMLのidのdbPulArrayにメソッドが呼ばれるたび元から追加してあるかずと削除した数をプラスしていく
		 $(clone).find("#dbPulArray").attr("id", "dbPulArray" +
				 (dbVerPulArrayNum + parseInt(sessionStorage.getItem("dbPulDelete"))));
		 // cloneしたHTMLのidのdbVerPulArrayにメソッドが呼ばれるたび元から追加してあるかずと削除した数をプラスしていく
		 $(clone).find("#dbVerPulArray").attr("id", "dbVerPulArray" +
				 (dbVerPulArrayNum + parseInt(sessionStorage.getItem("dbPulDelete"))));
	 // 登録ボタンを一度以上押して、尚且つ削除していない場合
	 } else if (Math.sign(sessionStorage.getItem("dbVerPulArrayNum")) == 1
				&& sessionStorage.getItem("dbPulDelete") == null) {
		 // cloneしたHTMLのidのdbPulArrayにメソッドが呼ばれるたび元から追加してある数に1ずつプラスしていく
		 $(clone).find("#dbPulArray").attr("id", "dbPulArray" +
				 (parseInt(sessionStorage.getItem("dbVerPulArrayNum")) + dbVerPulArrayNum));
		 // cloneしたHTMLのidのdbVerPulArrayにメソッドが呼ばれるたび元から追加してある数に1ずつプラスしていく
		 $(clone).find("#dbVerPulArray").attr("id", "dbVerPulArray" +
				 (parseInt(sessionStorage.getItem("dbVerPulArrayNum")) + dbVerPulArrayNum));
	 // 登録ボタンを一度以上押して、尚且つ削除もしている場合
	 } else if (Math.sign(sessionStorage.getItem("dbVerPulArrayNum")) == 1
				&& Math.sign(sessionStorage.getItem("dbPulDelete")) == 1) {
		 // idのナンバーを計算
		 let idNumber = ((parseInt(sessionStorage.getItem("dbVerPulArrayNum")) +
					parseInt(sessionStorage.getItem("dbPulDelete")))) + dbVerPulArrayNum;
		 // cloneしたHTMLのidのdbPulArrayにメソッドが呼ばれる度計算された番号が振られる
		 $(clone).find("#dbPulArray").attr("id", "dbPulArray" + idNumber);
		 // cloneしたHTMLのidのdbVerPulArrayにメソッドが呼ばれる度計算された番号が振られる
		 $(clone).find("#dbVerPulArray").attr("id", "dbVerPulArray" + idNumber);
		 // cloneしたHTMLのvalueを指定なしに変更
		 $(clone).find("#dbPulArray" + idNumber).val("指定なし");
		 // cloneしたHTMLのvalueを空文字に変更
		 $(clone).find("#dbVerPulArray" + idNumber).val("");
	 }
	 // cloneしたHTMLのvalueを空文字に変更
	 $(clone).find("#dbVerPulArray" + dbVerPulArrayNum).val("");
	 // cloneしたHTMLが一度削除されまたcloneされた時にvalueを空文字に変更
	 $(clone).find("#dbVerPulArray" + (dbVerPulArrayNum
			 + parseInt(sessionStorage.getItem("dbPulDelete")))).val("");
	 // 登録後バリデーションエラー発生後にcloneした時に追加したセレクトボックスの値を指定なしに変更
	 $(clone).find("#dbPulArray" + (parseInt(sessionStorage.getItem("dbVerPulArrayNum"))
			 + dbVerPulArrayNum)).val("指定なし");
	 // 登録後バリデーションエラー発生後にcloneした時に追加した入力フォームの値を空文字に変更
	 $(clone).find("#dbVerPulArray" + (parseInt(sessionStorage.getItem("dbVerPulArrayNum"))
			 + dbVerPulArrayNum)).val("");
	 //複製した要素を追加
	 $(this).parent().append(clone);
	 $(this).parent().append(
		'<input type="button" class="del delrelative" id="dbPul">'
	 );
  });

  // DBプルダウンが削除された回数を管理するメソッド
  $(document).on("click", "#dbPul", function() {
	  // 追加の入力フォームの数
      dbVerPulArrayNum--;
      // このメソッドが呼ばれた回数
	  dbPulDelete++;
	  // メソッドが呼ばれた回数をセッションに保持
	  sessionStorage.setItem("dbPulDelete", dbPulDelete);
  });

  // add_db2クラスのついたボタンが押されたとき、DB欄を増やす
  // セレクトボックス＋テキストボックス＋削除ボタン。を挿入する

  //idが「addb_db2」の要素を取得
  let add_db2 = document.getElementById("add_db2");

  add_db2.addEventListener("click", function(){
	  //idが「box_db2」の要素を取得
	  let box_db2 = document.getElementById("box_db2");
	  //「box_db2」の要素を複製（コピー）
	  let clone = box_db2.cloneNode(true);
	  // add_db2.addEventListener()メソッドが呼ばれた回数
	  dbArrayNum++;
	  // メソッド呼ばれた回数取得　クローンするたびIDにプラス1ずつ足していく
	  // 登録ボタンを押しておらず、尚且つ削除もしていない場合
	  if (sessionStorage.getItem("dbArrayNum") == null
			  && sessionStorage.getItem("dbDelete") == null
			  || sessionStorage.getItem("dbArrayNum") == 0
			  && sessionStorage.getItem("dbDelete") == null) {
		  // cloneしたHTMLのidのdbArrayにメソッドが呼ばれるプラス1ずつ足していく
		  $(clone).find('#dbArray').attr('id', 'dbArray' + dbArrayNum);
		  // cloneしたHTMLのidのdbVerArrayにメソッドが呼ばれるプラス1ずつ足していく
		  $(clone).find('#dbVerArray').attr('id', 'dbVerArray' + dbArrayNum);
	  // 登録ボタンを押しておらず、尚且つ削除している場合
	  } else if (sessionStorage.getItem("dbArrayNum") == null
			  && Math.sign(sessionStorage.getItem("dbDelete")) == 1) {
		  // cloneしたHTMLのidのdbArrayにメソッドが呼ばれるたび元から追加してあるかずと削除した数をプラスしていく
		  $(clone).find('#dbArray').attr('id', 'dbArray' +
				  (dbArrayNum + parseInt(sessionStorage.getItem("dbDelete"))));
		  // cloneしたHTMLのidのdbVerArrayにメソッドが呼ばれるたび元から追加してあるかずと削除した数をプラスしていく
		  $(clone).find('#dbVerArray').attr('id', 'dbVerArray' +
				  (dbArrayNum + parseInt(sessionStorage.getItem("dbDelete"))));
	  // 登録ボタンを一度以上押して、尚且つ削除していない場合
	  } else if (Math.sign(sessionStorage.getItem("dbArrayNum")) == 1
			  && sessionStorage.getItem("dbDelete") == null) {
		 // cloneしたHTMLのidのdbArrayにメソッドが呼ばれるたび元から追加してある数に1ずつプラスしていく
		 $(clone).find("#dbArray").attr("id", "dbArray" +
			(parseInt(sessionStorage.getItem("dbArrayNum")) + dbArrayNum));
		 // cloneしたHTMLのidのdbVerArrayにメソッドが呼ばれるたび元から追加してある数に1ずつプラスしていく
		 $(clone).find("#dbVerArray").attr("id", "dbVerArray" +
			(parseInt(sessionStorage.getItem("dbArrayNum")) + dbArrayNum));
	  // 登録ボタンを一度以上押して、尚且つ削除もしている場合
	  } else if (Math.sign(sessionStorage.getItem("dbArrayNum")) == 1
				&& Math.sign(sessionStorage.getItem("dbDelete")) == 1) {
		 // idのナンバーを計算
		 let idNumber = ((parseInt(sessionStorage.getItem("dbArrayNum")) +
					parseInt(sessionStorage.getItem("dbDelete")))) + dbArrayNum;
		 // cloneしたHTMLのidのdbArrayにメソッドが呼ばれる度計算された番号が振られる
		 $(clone).find("#dbArray").attr("id", "dbArray" + idNumber);
		 // cloneしたHTMLのidのdbVerArrayにメソッドが呼ばれる度計算された番号が振られる
		 $(clone).find("#dbVerArray").attr("id", "dbVerArray" + idNumber);
		 // cloneしたHTMLのvalueを空文字に変更
		 $(clone).find("#dbArray" + idNumber).val("");
		 // cloneしたHTMLのvalueを空文字に変更
		 $(clone).find("#dbVerArray" + idNumber).val("");
	 }
	  // cloneしたHTMLのvalueを空文字に変更
	  $(clone).find("#dbArray"+ dbArrayNum).val("");
	  // cloneしたHTMLのvalueを空文字に変更
	  $(clone).find("#dbVerArray"+ dbArrayNum).val("");
	  // cloneしたHTMLが一度削除されまたcloneされた時にvalueを空文字に変更
	  $(clone).find("#dbArray" + (dbArrayNum
			  + parseInt(sessionStorage.getItem("dbDelete")))).val("");
	  // cloneしたHTMLが一度削除されまたcloneされた時にvalueを空文字に変更
	  $(clone).find("#dbVerArray" + (dbArrayNum
			  + parseInt(sessionStorage.getItem("dbDelete")))).val("");
	  // 登録後バリデーションエラー発生後にcloneした時に追加した入力フォームの値を空文字に変更
	  $(clone).find("#dbArray" + (parseInt(sessionStorage.getItem("dbArrayNum"))
			  + dbArrayNum)).val("");
	  // 登録後バリデーションエラー発生後にcloneした時に追加した入力ボックスの値を空文字に変更
	  $(clone).find("#dbVerArray" + (parseInt(sessionStorage.getItem("dbArrayNum"))
				 + dbArrayNum)).val("");
	  //複製した要素を追加
	  $(this).parent().append(clone);
	  $(this).parent().append(
	     '<input type="button" class="del delrelative" id="db">'
	  );
  });

  //DBが削除された回数を管理するメソッド
  $(document).on("click", "#db", function() {
	  // 追加の入力フォームの数
	  dbArrayNum--;
      // このメソッドが呼ばれた回数
	  dbDelete++;
	  // メソッドが呼ばれた回数をセッションに保持
	  sessionStorage.setItem("dbDelete", dbDelete);
  });

  //add_fwクラスのついたボタンが押されたとき、FW/NW欄を増やす
  // セレクトボックス＋テキストボックス＋削除ボタン。を挿入する

  //idが「add_fw」の要素を取得
  let add_fw = document.getElementById("add_fw");

  add_fw.addEventListener("click", function(){
	  //idが「box_fw」の要素を取得
	  let box_fw = document.getElementById("box_fw");
	  //「box_fw」の要素を複製（コピー）
	  let clone = box_fw.cloneNode(true);
	  // add_fw.addEventListener()メソッドが呼ばれた回数
	  fwNwArrayNum++;
	  // メソッド呼ばれた回数取得　クローンするたびIDにプラス1ずつ足していく
	  // 登録ボタンを押しておらず、尚且つ削除もしていない場合
	  if (sessionStorage.getItem("fwNwArrayNum") == null
			  && sessionStorage.getItem("fwNwDelete") == null
			  || sessionStorage.getItem("fwNwArrayNum") == 0
			  && sessionStorage.getItem("fwNwDelete") == null) {
		  // cloneしたHTMLのidのfwNwArrayにメソッドが呼ばれるプラス1ずつ足していく
		  $(clone).find("#fwNwArray").attr("id", "fwNwArray" + fwNwArrayNum);
		  // cloneしたHTMLのidのfwNwVerArrayにメソッドが呼ばれるプラス1ずつ足していく
		  $(clone).find("#fwNwVerArray").attr("id", "fwNwVerArray" + fwNwArrayNum);
	  // 登録ボタンを押しておらず、尚且つ削除している場合
	  } else if (sessionStorage.getItem("fwNwArrayNum") == null
			  && Math.sign(sessionStorage.getItem("fwNwDelete")) == 1) {
		  // cloneしたHTMLのidのfwNwArrayにメソッドが呼ばれるたび元から追加してあるかずと削除した数をプラスしていく
		  $(clone).find("#fwNwArray").attr("id", "fwNwArray" +
				  (fwNwArrayNum + parseInt(sessionStorage.getItem("fwNwDelete"))));
		  // cloneしたHTMLのidのfwNwVerArrayにメソッドが呼ばれるたび元から追加してあるかずと削除した数をプラスしていく
		  $(clone).find("#fwNwVerArray").attr("id", "fwNwVerArray" +
				  (fwNwArrayNum + parseInt(sessionStorage.getItem("fwNwDelete"))));
	  // 登録ボタンを一度以上押して、尚且つ削除していない場合
	  } else if (Math.sign(sessionStorage.getItem("fwNwArrayNum")) == 1
			  && sessionStorage.getItem("fwNwDelete") == null) {
		 // cloneしたHTMLのidのfwNwArrayにメソッドが呼ばれるたび元から追加してある数に1ずつプラスしていく
		 $(clone).find("#fwNwArray").attr("id", "fwNwArray" +
			(parseInt(sessionStorage.getItem("fwNwArrayNum")) + fwNwArrayNum));
		 // cloneしたHTMLのidのfwNwVerArrayにメソッドが呼ばれるたび元から追加してある数に1ずつプラスしていく
		 $(clone).find("#fwNwVerArray").attr("id", "fwNwVerArray" +
			(parseInt(sessionStorage.getItem("fwNwArrayNum")) + fwNwArrayNum));
	  // 登録ボタンを一度以上押して、尚且つ削除もしている場合
	  } else if (Math.sign(sessionStorage.getItem("fwNwArrayNum")) == 1
				&& Math.sign(sessionStorage.getItem("fwNwDelete")) == 1) {
		 // idのナンバーを計算
		 let idNumber = ((parseInt(sessionStorage.getItem("fwNwArrayNum")) +
					parseInt(sessionStorage.getItem("fwNwDelete")))) + fwNwArrayNum;
		 // cloneしたHTMLのidのfwNwArrayにメソッドが呼ばれる度計算された番号が振られる
		 $(clone).find("#fwNwArray").attr("id", "fwNwArray" + idNumber);
		 // cloneしたHTMLのidのfwNwVerArrayにメソッドが呼ばれる度計算された番号が振られる
		 $(clone).find("#fwNwVerArray").attr("id", "fwNwVerArray" + idNumber);
		 // cloneしたHTMLのvalueを空文字に変更
		 $(clone).find("#fwNwArray" + idNumber).val("");
		 // cloneしたHTMLのvalueを空文字に変更
		 $(clone).find("#fwNwVerArray" + idNumber).val("");
	 }
	  // cloneしたHTMLのvalueを空文字に変更
	  $(clone).find("#fwNwArray"+ fwNwArrayNum).val("");
	  // cloneしたHTMLのvalueを空文字に変更
	  $(clone).find("#fwNwVerArray"+ fwNwArrayNum).val("");
	  // cloneしたHTMLが一度削除されまたcloneされた時にvalueを空文字に変更
	  $(clone).find("#fwNwArray" + (fwNwArrayNum
			  + parseInt(sessionStorage.getItem("fwNwDelete")))).val("");
	  // cloneしたHTMLが一度削除されまたcloneされた時にvalueを空文字に変更
	  $(clone).find("#fwNwVerArray" + (fwNwArrayNum
			  + parseInt(sessionStorage.getItem("fwNwDelete")))).val("");
	  // 登録後バリデーションエラー発生後にcloneした時に追加した入力フォームの値を空文字に変更
	  $(clone).find("#fwNwArray" + (parseInt(sessionStorage.getItem("fwNwArrayNum"))
			  + fwNwArrayNum)).val("");
	  // 登録後バリデーションエラー発生後にcloneした時に追加した入力ボックスの値を空文字に変更
	  $(clone).find("#fwNwVerArray" + (parseInt(sessionStorage.getItem("fwNwArrayNum"))
				 + fwNwArrayNum)).val("");
	  //複製した要素を追加
	  $(this).parent().append(clone);
	  $(this).parent().append(
		  '<input type="button" class="del delrelative" id="fwNw" >'
	  );
  });

  //FW/NWが削除された回数を管理するメソッド
  $(document).on("click", "#fwNw", function() {
	  // 追加の入力フォームの数
	  fwNwArrayNum--;
      // このメソッドが呼ばれた回数
	  fwNwDelete++;
	  // メソッドが呼ばれた回数をセッションに保持
	  sessionStorage.setItem("fwNwDelete", fwNwDelete);
  });

  //add_osクラスのついたボタンが押されたとき、OS欄を増やす
  // セレクトボックス＋テキストボックス＋削除ボタン。を挿入する

  //idが「add_os」の要素を取得
  let add_os = document.getElementById("add_os");

  add_os.addEventListener("click", function(){
	  //idが「box_os」の要素を取得
	  let box_os = document.getElementById("box_os");
	  //「box_os」の要素を複製（コピー）
	  let clone = box_os.cloneNode(true);
	  // add_os.addEventListener()メソッドが呼ばれた回数
	  osVerPulArrayNum++;
	  // メソッド呼ばれた回数取得　クローンするたびIDにプラス1ずつ足していく
	  // 登録ボタンを押しておらず、尚且つ削除もしていない場合
	  if (sessionStorage.getItem("osVerPulArrayNum") == null
			  && sessionStorage.getItem("osPulDelete") == null
			  || sessionStorage.getItem("osVerPulArrayNum") == 0
			  && sessionStorage.getItem("osPulDelete") == null) {
		  // cloneしたHTMLのidのosPulArrayにメソッドが呼ばれるたびプラス1ずつ足していく
		  $(clone).find("#osPulArray").attr("id", "osPulArray" + osVerPulArrayNum);
		  // cloneしたHTMLのidのosVerPulArrayにメソッドが呼ばれるたびプラス1ずつ足していく
		  $(clone).find("#osVerPulArray").attr("id", "osVerPulArray" + osVerPulArrayNum);
	  // 登録ボタンを押しておらず、尚且つ削除している場合
	  } else if (sessionStorage.getItem("osVerPulArrayNum") == null
			  && Math.sign(sessionStorage.getItem("osPulDelete")) == 1) {
		  // cloneしたHTMLのidのosPulArrayにメソッドが呼ばれるたび元から追加してあるかずと削除した数をプラスしていく
		  $(clone).find("#osPulArray").attr("id", "osPulArray" +
				  (osVerPulArrayNum + parseInt(sessionStorage.getItem("osPulDelete"))));
		  // cloneしたHTMLのidのosVerPulArrayにメソッドが呼ばれるたび元から追加してあるかずと削除した数をプラスしていく
		  $(clone).find("#osVerPulArray").attr("id", "osVerPulArray" +
				  (osVerPulArrayNum + parseInt(sessionStorage.getItem("osPulDelete"))));
	  // 登録ボタンを一度以上押して、尚且つ削除していない場合
	  } else if (Math.sign(sessionStorage.getItem("osVerPulArrayNum")) == 1
			  && sessionStorage.getItem("osPulDelete") == null) {
		  // cloneしたHTMLのidのosPulArrayにメソッドが呼ばれるたび元から追加してある数に1ずつプラスしていく
		  $(clone).find("#osPulArray").attr("id", "osPulArray" +
				  (parseInt(sessionStorage.getItem("osVerPulArrayNum")) + osVerPulArrayNum));
		  // cloneしたHTMLのidのosVerPulArrayにメソッドが呼ばれるたび元から追加してある数に1ずつプラスしていく
		  $(clone).find("#osVerPulArray").attr("id", "osVerPulArray" +
				  (parseInt(sessionStorage.getItem("osVerPulArrayNum")) + osVerPulArrayNum));
	  // 登録ボタンを一度以上押して、尚且つ削除もしている場合
	  } else if (Math.sign(sessionStorage.getItem("osVerPulArrayNum")) == 1
			  && Math.sign(sessionStorage.getItem("osPulDelete")) == 1) {
		  // idのナンバーを計算
		  let idNumber = ((parseInt(sessionStorage.getItem("osVerPulArrayNum")) +
				  parseInt(sessionStorage.getItem("osPulDelete")))) + osVerPulArrayNum;
		  // cloneしたHTMLのidのosPulArrayにメソッドが呼ばれる度計算された番号が振られる
		  $(clone).find("#osPulArray").attr("id", "osPulArray" + idNumber);
		  // cloneしたHTMLのidのosVerPulArrayにメソッドが呼ばれる度計算された番号が振られる
		  $(clone).find("#osVerPulArray").attr("id", "osVerPulArray" + idNumber);
		  // cloneしたHTMLのvalueを指定なしに変更
		  $(clone).find("#osPulArray" + idNumber).val("指定なし");
		  // cloneしたHTMLのvalueを空文字に変更
		  $(clone).find("#osVerPulArray" + idNumber).val("");
	  }
	  // cloneしたHTMLのvalueを空文字に変更
	  $(clone).find("#osVerPulArray" + osVerPulArrayNum).val("");
	  // cloneしたHTMLが一度削除されまたcloneされた時にvalueを空文字に変更
	  $(clone).find("#osVerPulArray" + (osVerPulArrayNum
			  + parseInt(sessionStorage.getItem("osPulDelete")))).val("");
	  // 登録後バリデーションエラー発生後にcloneした時に追加した入力フォームの値を空文字に変更
	  $(clone).find("#osVerPulArray" + (parseInt(sessionStorage.getItem("osVerPulArrayNum"))
			  + osVerPulArrayNum)).val("");
	  // 登録後バリデーションエラー発生後にcloneした時に追加したセレクトボックスの値を指定なしに変更
	  $(clone).find("#osPulArray" + (parseInt(sessionStorage.getItem("osVerPulArrayNum"))
			  + osVerPulArrayNum)).val("指定なし");
	  //複製した要素を追加
	  $(this).parent().append(clone);
	  $(this).parent().append(
		  '<input type="button" class="del delrelative" id="osPul">'
	  );
  });

  //OSが削除された回数を管理するメソッド
  $(document).on("click", "#osPul", function() {
	  // 追加の入力フォームの数
	  osVerPulArrayNum--;
      // このメソッドが呼ばれた回数
	  osPulDelete++;
	  // メソッドが呼ばれた回数をセッションに保持
	  sessionStorage.setItem("osPulDelete", osPulDelete);
  });

  //add_os2クラスのついたボタンが押されたとき、OS欄を増やす
  // セレクトボックス＋テキストボックス＋削除ボタン。を挿入する

  //idが「add_os2」の要素を取得
  let add_os2 = document.getElementById("add_os2");

  add_os2.addEventListener("click", function(){
	  //idが「box_os2」の要素を取得
	  let box_os2 = document.getElementById("box_os2");
	  //「box_os2」の要素を複製（コピー）
	  let clone = box_os2.cloneNode(true);
	  // add_os2.addEventListener()メソッドが呼ばれた回数
	  osArrayNum++;
	  // メソッド呼ばれた回数取得　クローンするたびIDにプラス1ずつ足していく
	  // 登録ボタンを押しておらず、尚且つ削除もしていない場合
	  if (sessionStorage.getItem("osArrayNum") == null
			  && sessionStorage.getItem("osDelete") == null
			  || sessionStorage.getItem("osArrayNum") == 0
			  && sessionStorage.getItem("osDelete") == null) {
		  // cloneしたHTMLのidのosArrayにメソッドが呼ばれるプラス1ずつ足していく
		  $(clone).find("#osArray").attr("id", "osArray" + osArrayNum);
		  // cloneしたHTMLのidのdbVerArrayにメソッドが呼ばれるプラス1ずつ足していく
		  $(clone).find("#osVerArray").attr("id", "osVerArray" + osArrayNum);
	  // 登録ボタンを押しておらず、尚且つ削除している場合
	  } else if (sessionStorage.getItem("osArrayNum") == null
			  && Math.sign(sessionStorage.getItem("osDelete")) == 1) {
		  // cloneしたHTMLのidのosArrayにメソッドが呼ばれるたび元から追加してあるかずと削除した数をプラスしていく
		  $(clone).find("#osArray").attr("id", "osArray" +
				  (osArrayNum + parseInt(sessionStorage.getItem("osDelete"))));
		  // cloneしたHTMLのidのosVerArrayにメソッドが呼ばれるたび元から追加してあるかずと削除した数をプラスしていく
		  $(clone).find("#osVerArray").attr("id", "osVerArray" +
				  (osArrayNum + parseInt(sessionStorage.getItem("osDelete"))));
	  // 登録ボタンを一度以上押して、尚且つ削除していない場合
	  } else if (Math.sign(sessionStorage.getItem("osArrayNum")) == 1
			  && sessionStorage.getItem("osDelete") == null) {
		 // cloneしたHTMLのidのosArrayにメソッドが呼ばれるたび元から追加してある数に1ずつプラスしていく
		 $(clone).find("#osArray").attr("id", "osArray" +
			(parseInt(sessionStorage.getItem("osArrayNum")) + osArrayNum));
		 // cloneしたHTMLのidのosVerArrayにメソッドが呼ばれるたび元から追加してある数に1ずつプラスしていく
		 $(clone).find("#osVerArray").attr("id", "osVerArray" +
			(parseInt(sessionStorage.getItem("osArrayNum")) + osArrayNum));
	  // 登録ボタンを一度以上押して、尚且つ削除もしている場合
	  } else if (Math.sign(sessionStorage.getItem("osArrayNum")) == 1
				&& Math.sign(sessionStorage.getItem("osDelete")) == 1) {
		 // idのナンバーを計算
		 let idNumber = ((parseInt(sessionStorage.getItem("osArrayNum")) +
					parseInt(sessionStorage.getItem("osDelete")))) + osArrayNum;
		 // cloneしたHTMLのidのosArrayにメソッドが呼ばれる度計算された番号が振られる
		 $(clone).find("#osArray").attr("id", "osArray" + idNumber);
		 // cloneしたHTMLのidのosVerArrayにメソッドが呼ばれる度計算された番号が振られる
		 $(clone).find("#osVerArray").attr("id", "osVerArray" + idNumber);
		 // cloneしたHTMLのvalueを空文字に変更
		 $(clone).find("#osArray" + idNumber).val("");
		 // cloneしたHTMLのvalueを空文字に変更
		 $(clone).find("#osVerArray" + idNumber).val("");
	  }
	  // cloneしたHTMLのvalueを空文字に変更
	  $(clone).find("#osArray"+ osArrayNum).val("");
	  // cloneしたHTMLのvalueを空文字に変更
	  $(clone).find("#osVerArray"+ osArrayNum).val("");
	  // cloneしたHTMLが一度削除されまたcloneされた時にvalueを空文字に変更
	  $(clone).find("#osArray" + (osArrayNum
			  + parseInt(sessionStorage.getItem("osDelete")))).val("");
	  // cloneしたHTMLが一度削除されまたcloneされた時にvalueを空文字に変更
	  $(clone).find("#osVerArray" + (osArrayNum
			  + parseInt(sessionStorage.getItem("osDelete")))).val("");
	  // 登録後バリデーションエラー発生後にcloneした時に追加した入力フォームの値を空文字に変更
	  $(clone).find("#osArray" + (parseInt(sessionStorage.getItem("osArrayNum"))
			  + osArrayNum)).val("");
	  // 登録後バリデーションエラー発生後にcloneした時に追加した入力ボックスの値を空文字に変更
	  $(clone).find("#osVerArray" + (parseInt(sessionStorage.getItem("osArrayNum"))
				 + osArrayNum)).val("");
	  //複製した要素を追加
	  $(this).parent().append(clone);
	  $(this).parent().append(
		  '<input type="button" class="del delrelative" id="os">'
	  );
  });

  //OSが削除された回数を管理するメソッド
  $(document).on("click", "#os", function() {
	  // 追加の入力フォームの数
	  osArrayNum--;
      // このメソッドが呼ばれた回数
	  osDelete++;
	  // メソッドが呼ばれた回数をセッションに保持
	  sessionStorage.setItem("osDelete", osDelete);
  });

  //add_langクラスのついたボタンが押されたとき、言語欄を増やす
  // セレクトボックス＋テキストボックス＋削除ボタン。を挿入する

  //idが「add_lang」の要素を取得
  let add_lang = document.getElementById("add_lang");

  add_lang.addEventListener("click", function(){
	  //idが「box_lang」の要素を取得
	  let box_lang = document.getElementById("box_lang");
	  //「box_lang」の要素を複製（コピー）
	  let clone = box_lang.cloneNode(true);
	  // add_lang.addEventListener()メソッドが呼ばれた回数
	  languageVerPulArrayNum++;
	  // メソッド呼ばれた回数取得　クローンするたびIDにプラス1ずつ足していく
	  // 登録ボタンを押しておらず、尚且つ削除もしていない場合
	  if (sessionStorage.getItem("languageVerPulArrayNum") == null
			  && sessionStorage.getItem("languagePulDelete") == null
			  || sessionStorage.getItem("languageVerPulArrayNum") == 0
			  && sessionStorage.getItem("languagePulDelete") == null) {
		  // cloneしたHTMLのidのlanguagePulArrayにメソッドが呼ばれるたびプラス1ずつ足していく
		  $(clone).find("#languagePulArray").attr("id", "languagePulArray" + languageVerPulArrayNum);
		  // cloneしたHTMLのidのlanguageVerPulArrayにメソッドが呼ばれるたびプラス1ずつ足していく
		  $(clone).find("#languageVerPulArray").attr("id", "languageVerPulArray" + languageVerPulArrayNum);
	  // 登録ボタンを押しておらず、尚且つ削除している場合
	  } else if (sessionStorage.getItem("languageVerPulArrayNum") == null
			  && Math.sign(sessionStorage.getItem("languagePulDelete")) == 1) {
		  // cloneしたHTMLのidのlanguagePulArrayにメソッドが呼ばれるたび元から追加してあるかずと削除した数をプラスしていく
		  $(clone).find("#languagePulArray").attr("id", "languagePulArray" +
				  (languageVerPulArrayNum + parseInt(sessionStorage.getItem("languagePulDelete"))));
		  // cloneしたHTMLのidのlanguageVerPulArrayにメソッドが呼ばれるたび元から追加してあるかずと削除した数をプラスしていく
		  $(clone).find("#languageVerPulArray").attr("id", "languageVerPulArray" +
				  (languageVerPulArrayNum + parseInt(sessionStorage.getItem("languagePulDelete"))));
	  // 登録ボタンを一度以上押して、尚且つ削除していない場合
	  } else if (Math.sign(sessionStorage.getItem("languageVerPulArrayNum")) == 1
			  && sessionStorage.getItem("languagePulDelete") == null) {
		  // cloneしたHTMLのidのlanguagePulArrayにメソッドが呼ばれるたび元から追加してある数に1ずつプラスしていく
		  $(clone).find("#languagePulArray").attr("id", "languagePulArray" +
				  (parseInt(sessionStorage.getItem("languageVerPulArrayNum")) + languageVerPulArrayNum));
		  // cloneしたHTMLのidのlanguageVerPulArrayにメソッドが呼ばれるたび元から追加してある数に1ずつプラスしていく
		  $(clone).find("#languageVerPulArray").attr("id", "languageVerPulArray" +
				  (parseInt(sessionStorage.getItem("languageVerPulArrayNum")) + languageVerPulArrayNum));
	  // 登録ボタンを一度以上押して、尚且つ削除もしている場合
	  } else if (Math.sign(sessionStorage.getItem("languageVerPulArrayNum")) == 1
			  && Math.sign(sessionStorage.getItem("languagePulDelete")) == 1) {
		  // idのナンバーを計算
		  let idNumber = ((parseInt(sessionStorage.getItem("languageVerPulArrayNum")) +
				  parseInt(sessionStorage.getItem("languagePulDelete")))) + osVerPulArrayNum;
		  // cloneしたHTMLのidのlanguagePulArrayにメソッドが呼ばれる度計算された番号が振られる
		  $(clone).find("#languagePulArray").attr("id", "languagePulArray" + idNumber);
		  // cloneしたHTMLのidのlanguageVerPulArrayにメソッドが呼ばれる度計算された番号が振られる
		  $(clone).find("#languageVerPulArray").attr("id", "languageVerPulArray" + idNumber);
		  // cloneしたHTMLのvalueを指定なしに変更
		  $(clone).find("#languagePulArray" + idNumber).val("指定なし");
		  // cloneしたHTMLのvalueを空文字に変更
		  $(clone).find("#languageVerPulArray" + idNumber).val("");
	  }
	  // cloneしたHTMLのvalueを空文字に変更
	  $(clone).find("#languageVerPulArray" + languageVerPulArrayNum).val("");
	  // cloneしたHTMLが一度削除されまたcloneされた時にvalueを空文字に変更
	  $(clone).find("#languageVerPulArray" + (languageVerPulArrayNum
			  + parseInt(sessionStorage.getItem("languagePulDelete")))).val("");
	  // 登録後バリデーションエラー発生後にcloneした時に追加した入力フォームの値を空文字に変更
	  $(clone).find("#languageVerPulArray" + (parseInt(sessionStorage.getItem("languageVerPulArrayNum"))
			  + languageVerPulArrayNum)).val("");
	  // 登録後バリデーションエラー発生後にcloneした時に追加したセレクトボックスの値を指定なしに変更
	  $(clone).find("#languagePulArray" + (parseInt(sessionStorage.getItem("languageVerPulArrayNum"))
			  + languageVerPulArrayNum)).val("指定なし");
	  //複製した要素を追加
	  $(this).parent().append(clone);
	  $(this).parent().append(
		  '<input type="button" class="del delrelative" id="languagePul">'
	  );
  });

  // 言語が削除された回数を管理するメソッド
  $(document).on("click", "#languagePul", function() {
	  // 追加の入力フォームの数
	  languageVerPulArrayNum--;
      // このメソッドが呼ばれた回数
	  languagePulDelete++;
	  // メソッドが呼ばれた回数をセッションに保持
	  sessionStorage.setItem("languagePulDelete", languagePulDelete);
  });

  //add_lang2クラスのついたボタンが押されたとき、言語欄を増やす
  // セレクトボックス＋テキストボックス＋削除ボタン。を挿入する

  //idが「add_lang2」の要素を取得
  let add_lang2 = document.getElementById("add_lang2");

  add_lang2.addEventListener("click", function(){
	  //idが「box_lang」の要素を取得
	  let box_lang2 = document.getElementById("box_lang2");
	  //「box_lang」の要素を複製（コピー）
	  let clone = box_lang2.cloneNode(true)
	  // add_lang2.addEventListener()メソッドが呼ばれた回数
	  languageArrayNum++;
	  // メソッド呼ばれた回数取得　クローンするたびIDにプラス1ずつ足していく
	  // 登録ボタンを押しておらず、尚且つ削除もしていない場合
	  if (sessionStorage.getItem("languageArrayNum") == null
			  && sessionStorage.getItem("languageDelete") == null
			  || sessionStorage.getItem("languageArrayNum") == 0
			  && sessionStorage.getItem("languageDelete") == null) {
		  // cloneしたHTMLのidのlanguageArrayにメソッドが呼ばれるプラス1ずつ足していく
		  $(clone).find("#languageArray").attr("id", "languageArray" + languageArrayNum);
		  // cloneしたHTMLのidのlanguageVerArrayにメソッドが呼ばれるプラス1ずつ足していく
		  $(clone).find("#languageVerArray").attr("id", "languageVerArray" + languageArrayNum);
	  // 登録ボタンを押しておらず、尚且つ削除している場合
	  } else if (sessionStorage.getItem("languageArrayNum") == null
			  && Math.sign(sessionStorage.getItem("languageDelete")) == 1) {
		  // cloneしたHTMLのidのlanguageArrayにメソッドが呼ばれるたび元から追加してあるかずと削除した数をプラスしていく
		  $(clone).find("#languageArray").attr("id", "languageArray" +
				  (languageArrayNum + parseInt(sessionStorage.getItem("languageDelete"))));
		  // cloneしたHTMLのidのlanguageVerArrayにメソッドが呼ばれるたび元から追加してあるかずと削除した数をプラスしていく
		  $(clone).find("#languageVerArray").attr("id", "languageVerArray" +
				  (languageArrayNum + parseInt(sessionStorage.getItem("languageDelete"))));
	  // 登録ボタンを一度以上押して、尚且つ削除していない場合
	  } else if (Math.sign(sessionStorage.getItem("languageArrayNum")) == 1
			  && sessionStorage.getItem("languageDelete") == null) {
		 // cloneしたHTMLのidのlanguageArrayにメソッドが呼ばれるたび元から追加してある数に1ずつプラスしていく
		 $(clone).find("#languageArray").attr("id", "languageArray" +
			(parseInt(sessionStorage.getItem("languageArrayNum")) + languageArrayNum));
		 // cloneしたHTMLのidのlanguageVerArrayにメソッドが呼ばれるたび元から追加してある数に1ずつプラスしていく
		 $(clone).find("#languageVerArray").attr("id", "languageVerArray" +
			(parseInt(sessionStorage.getItem("languageArrayNum")) + languageArrayNum));
	  // 登録ボタンを一度以上押して、尚且つ削除もしている場合
	  } else if (Math.sign(sessionStorage.getItem("languageArrayNum")) == 1
				&& Math.sign(sessionStorage.getItem("languageDelete")) == 1) {
		 // idのナンバーを計算
		 let idNumber = ((parseInt(sessionStorage.getItem("languageArrayNum")) +
					parseInt(sessionStorage.getItem("languageDelete")))) + languageArrayNum;
		 // cloneしたHTMLのidのlanguageArrayにメソッドが呼ばれる度計算された番号が振られる
		 $(clone).find("#languageArray").attr("id", "languageArray" + idNumber);
		 // cloneしたHTMLのidのlanguageVerArrayにメソッドが呼ばれる度計算された番号が振られる
		 $(clone).find("#languageVerArray").attr("id", "languageVerArray" + idNumber);
		 // cloneしたHTMLのvalueを空文字に変更
		 $(clone).find("#languageArray" + idNumber).val("");
		 // cloneしたHTMLのvalueを空文字に変更
		 $(clone).find("#languageVerArray" + idNumber).val("");
	  }
	  // cloneしたHTMLのvalueを空文字に変更
	  $(clone).find("#languageArray"+ languageArrayNum).val("");
	  // cloneしたHTMLのvalueを空文字に変更
	  $(clone).find("#languageVerArray"+ languageArrayNum).val("");
	  // cloneしたHTMLが一度削除されまたcloneされた時にvalueを空文字に変更
	  $(clone).find("#languageArray" + (languageArrayNum
			  + parseInt(sessionStorage.getItem("languageDelete")))).val("");
	  // cloneしたHTMLが一度削除されまたcloneされた時にvalueを空文字に変更
	  $(clone).find("#languageVerArray" + (languageArrayNum
			  + parseInt(sessionStorage.getItem("languageDelete")))).val("");
	  // 登録後バリデーションエラー発生後にcloneした時に追加した入力フォームの値を空文字に変更
	  $(clone).find("#languageArray" + (parseInt(sessionStorage.getItem("languageArrayNum"))
			  + languageArrayNum)).val("");
	  // 登録後バリデーションエラー発生後にcloneした時に追加した入力ボックスの値を空文字に変更
	  $(clone).find("#languageVerArray" + (parseInt(sessionStorage.getItem("languageArrayNum"))
				 + languageArrayNum)).val("");
	  //複製した要素を追加
	  $(this).parent().append(clone);
	  $(this).parent().append(
		  '<input type="button" class="del delrelative" id="language">'
	  );
  });

  //言語が削除された回数を管理するメソッド
  $(document).on("click", "#language", function() {
	  // 追加の入力フォームの数
	  languageArrayNum--;
      // このメソッドが呼ばれた回数
	  languageDelete++;
	  // メソッドが呼ばれた回数をセッションに保持
	  sessionStorage.setItem("languageDelete", languageDelete);
  });

  //add_otherクラスのついたボタンが押されたとき、その他欄を増やす
  // セレクトボックス＋テキストボックス＋削除ボタン。を挿入する

  //idが「add_other」の要素を取得
  let add_other = document.getElementById("add_other");

  add_other.addEventListener("click", function(){
	  //idが「box_other」の要素を取得
	  let box_other = document.getElementById("box_other");
	  //「box_other」の要素を複製（コピー）
	  let clone = box_other.cloneNode(true);
	  // add_other.addEventListener()メソッドが呼ばれた回数
	  otherArrayNum++;
	  // メソッド呼ばれた回数取得　クローンするたびIDにプラス1ずつ足していく
	  // 登録ボタンを押しておらず、尚且つ削除もしていない場合
	  if (sessionStorage.getItem("otherArrayNum") == null
			  && sessionStorage.getItem("otherDelete") == null
			  || sessionStorage.getItem("otherArrayNum") == 0
			  && sessionStorage.getItem("otherDelete") == null) {
		  // cloneしたHTMLのidのotherArrayにメソッドが呼ばれるプラス1ずつ足していく
		  $(clone).find("#otherArray").attr("id", "otherArray" + otherArrayNum);
		  // cloneしたHTMLのidのotherVerArrayにメソッドが呼ばれるプラス1ずつ足していく
		  $(clone).find("#otherVerArray").attr("id", "otherVerArray" + otherArrayNum);
	  // 登録ボタンを押しておらず、尚且つ削除している場合
	  } else if (sessionStorage.getItem("otherArrayNum") == null
			  && Math.sign(sessionStorage.getItem("otherDelete")) == 1) {
		  // cloneしたHTMLのidのotherArrayにメソッドが呼ばれるたび元から追加してあるかずと削除した数をプラスしていく
		  $(clone).find("#otherArray").attr("id", "otherArray" +
				  (otherArrayNum + parseInt(sessionStorage.getItem("otherDelete"))));
		  // cloneしたHTMLのidのotherVerArrayにメソッドが呼ばれるたび元から追加してあるかずと削除した数をプラスしていく
		  $(clone).find("#otherVerArray").attr("id", "otherVerArray" +
				  (otherArrayNum + parseInt(sessionStorage.getItem("otherDelete"))));
	  // 登録ボタンを一度以上押して、尚且つ削除していない場合
	  } else if (Math.sign(sessionStorage.getItem("otherArrayNum")) == 1
			  && sessionStorage.getItem("otherDelete") == null) {
		 // cloneしたHTMLのidのotherArrayにメソッドが呼ばれるたび元から追加してある数に1ずつプラスしていく
		 $(clone).find("#otherArray").attr("id", "otherArray" +
				 (parseInt(sessionStorage.getItem("otherArrayNum")) + otherArrayNum));
		 // cloneしたHTMLのidのotherVerArrayにメソッドが呼ばれるたび元から追加してある数に1ずつプラスしていく
		 $(clone).find("#otherVerArray").attr("id", "otherVerArray" +
				 (parseInt(sessionStorage.getItem("otherArrayNum")) + otherArrayNum));
	  // 登録ボタンを一度以上押して、尚且つ削除もしている場合
	  } else if (Math.sign(sessionStorage.getItem("otherArrayNum")) == 1
				&& Math.sign(sessionStorage.getItem("otherDelete")) == 1) {
		 // idのナンバーを計算
		 let idNumber = ((parseInt(sessionStorage.getItem("otherArrayNum")) +
					parseInt(sessionStorage.getItem("otherDelete")))) + otherArrayNum;
		 // cloneしたHTMLのidのotherArrayにメソッドが呼ばれる度計算された番号が振られる
		 $(clone).find("#otherArray").attr("id", "otherArray" + idNumber);
		 // cloneしたHTMLのidのotherVerArrayにメソッドが呼ばれる度計算された番号が振られる
		 $(clone).find("#otherVerArray").attr("id", "otherVerArray" + idNumber);
		 // cloneしたHTMLのvalueを空文字に変更
		 $(clone).find("#otherArray" + idNumber).val("");
		 // cloneしたHTMLのvalueを空文字に変更
		 $(clone).find("#otherVerArray" + idNumber).val("");
	  }
	  // cloneしたHTMLのvalueを空文字に変更
	  $(clone).find("#otherArray"+ otherArrayNum).val("");
	  // cloneしたHTMLのvalueを空文字に変更
	  $(clone).find("#otherVerArray"+ otherArrayNum).val("");
	  // cloneしたHTMLが一度削除されまたcloneされた時にvalueを空文字に変更
	  $(clone).find("#otherArray" + (otherArrayNum
			  + parseInt(sessionStorage.getItem("otherDelete")))).val("");
	  // cloneしたHTMLが一度削除されまたcloneされた時にvalueを空文字に変更
	  $(clone).find("#otherVerArray" + (otherArrayNum
			  + parseInt(sessionStorage.getItem("otherDelete")))).val("");
	  // 登録後バリデーションエラー発生後にcloneした時に追加した入力フォームの値を空文字に変更
	  $(clone).find("#otherArray" + (parseInt(sessionStorage.getItem("otherArrayNum"))
			  + otherArrayNum)).val("");
	  // 登録後バリデーションエラー発生後にcloneした時に追加した入力ボックスの値を空文字に変更
	  $(clone).find("#otherVerArray" + (parseInt(sessionStorage.getItem("otherArrayNum"))
			  + otherArrayNum)).val("");
	  //複製した要素を追加
	  $(this).parent().append(clone);
	  $(this).parent().append(
		  '<input type="button" class="del delrelative" id="other">'
	  );
  });

  //その他が削除された回数を管理するメソッド
  $(document).on("click", "#other", function() {
	  // 追加の入力フォームの数
	  otherArrayNum--;
      // このメソッドが呼ばれた回数
	  otherDelete++;
	  // メソッドが呼ばれた回数をセッションに保持
	  sessionStorage.setItem("otherDelete", otherDelete);
  });

//追加した入力欄を消す
  $(document).on("click", ".del", function() {
      var target = $(this).parent();
      if (target.parent().children().length > 1) {
          target.remove();
      }
  });

  // 全ての入力したものをクリアする
  $('#clear').on('click',function() {
   $(this).parent('form').find(':text').val("");
   $('select').prop("selectedIndex", 0);
   $('input').prop('checked', false);
    document.getElementById("re").innerHTML ="下のボタンより選択してください";
  });

//モーダルウィンドウの動きの設定
  {
    'use strict';
    const hiraku = document.getElementById('open');
    const tojiru = document.getElementById('close');
    const modal = document.getElementById('modal') ;
    const kakusu = document.getElementById('mask');

    hiraku.addEventListener('click', function () {
     modal.classList.remove('hidden');
     kakusu.classList.remove('hidden');
    });
    tojiru.addEventListener('click', function () {
     modal.classList.add('hidden');
     kakusu.classList.add('hidden');
    });
    kakusu.addEventListener('click', function () {
     modal.classList.add('hidden');
     kakusu.classList.add('hidden');
    });
    }

//モーダルウィンドウの閉じるボタンの動き
//モーダルウィンドウを閉じる
window.addEventListener('DOMContentLoaded', function(){
 $('#close').click(function modaleffect() {
   const modal = document.getElementById('modal');
   const kakusu = document.getElementById('mask');
     modal.classList.add('hidden');
     kakusu.classList.add('hidden');
   });
 });
//モーダルウィンドウの確定ボタンの動き
//チェックボックスで選択したものを親画面に表示、モーダルウィンドウを閉じる
window.addEventListener('DOMContentLoaded', function(){
 // モーダルウィンドウを閉じる
 $('#ok').click(function() {
 const modal = document.getElementById('modal');
 const kakusu = document.getElementById('mask');
 modal.classList.add('hidden');
 kakusu.classList.add('hidden');

 // チェックボックスで選択したものを抽出
    var input=[];
  $('input[name=checkboxfaze]:checked').each(function() {
    var plus = $(this).val();
    input.push(plus);
  });

  // 選択したものをから重複を消す
  var set = new Set(input);
  let setToArr = Array.from(set);
 // 選択したものを親画面に表示、無かったら初期値を入れる
  if (input.length <1) {
    document.getElementById("re").innerHTML ="下のボタンより選択してください";
    } else {
      document.getElementById("re").innerHTML =setToArr;
    }
    });
  });
// モーダルウィンドウのクリアボタンの動き
// チェックボックスのチェックを外す
  $('#modalclear').on('click',function() {
    $('input').prop('checked', false);
    document.getElementById("re").innerHTML ="下のボタンより選択してください";
   });
});

//画面を読み込んだ時、子画面にチェックがあれば担当フェーズを表示する
$(document).ready(function(){
  var input=[];
  $('input[name=checkboxfaze]:checked').each(function() {
    var plus = $(this).val();
    input.push(plus);
  });
  var set = new Set(input);
  let setToAll = Array.from(set);
      if(setToAll.length==0){
        document.getElementById("re").innerHTML ="下のボタンより選択してください";
      }else{
      document.getElementById("re").innerHTML =setToAll;
      }
      $("#textareaHight").trigger('autoheight');
});


/* テキストエリアの初期設定. */
// 最小値height:100pxで指定
$("#textareaHight").height(30);
$("#textareaHight").css("lineHeight","20px");

/**
 * 高さ自動調節イベントの定義.
 * autoheightという名称のイベントを追加します。
 * @param evt
 */
$("#textareaHight").on("autoheight", function(evt) {
  // 対象セレクタをセット
  var target = evt.target;

  // CASE1: スクロールする高さが対象セレクタの高さよりも大きい場合
  // ※スクロール表示される場合
  if (target.scrollHeight > target.offsetHeight) {
    // スクロールする高さをheightに指定
    $(target).height(target.scrollHeight);
  }
  // CASE2: スクロールする高さが対象セレクタの高さよりも小さい場合
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

//DB OS その他 FW/NW 言語の追加入力フォームの数、value保持
$(".regibtn").click(function() {
	// DBプルダウンの追加削除メソッドの呼び出し回数を保持
	if (Math.sign(dbVerPulArrayNum) == -1 || Math.sign(sessionStorage.getItem("dbVerPulArrayNum")) == 1
			|| sessionStorage.getItem("dbVerPulArrayNum") == 0) {
		sessionStorage.setItem("dbVerPulArrayNum",
		parseInt(sessionStorage.getItem("dbVerPulArrayNum")) + dbVerPulArrayNum);
	} else if (sessionStorage.getItem("dbVerPulArrayNum") == null) {
		sessionStorage.setItem("dbVerPulArrayNum", dbVerPulArrayNum);
	}
	// DBのプルダウン(デフォルトプルダウン)の情報取得
	sessionStorage.setItem("dbPulArrayValue", document.querySelector("#dbPulArray").value);
	// DBのプルダウンのバージョン(デフォルトプルダウンバージョン)の情報取得
	sessionStorage.setItem("dbVerPulArrayValue", document.querySelector("#dbVerPulArray").value);
	// DB(プルダウン)入力フォームを追加した場合のエラーメッセージ
	if (!(sessionStorage.getItem("dbVerPulArrayNum") == 0)) {
		// 追加の入力フォームを削除しているかチェック
		if (sessionStorage.getItem("dbPulDelete") == null) {
			// 追加の入力フォームを削除していない
			for (let i = 1; i <= sessionStorage.getItem("dbVerPulArrayNum"); i++) {
				// 追加したプルダウンのvalue取得
				if (document.querySelector("#dbPulArray" + i) != null) {
					sessionStorage.setItem("dbPulArrayAddValue" + i ,
							document.querySelector("#dbPulArray" + i).value);
				}
				// 追加したプルダウンのバージョンのvalue取得
				if (document.querySelector("#dbVerPulArray" + i) != null) {
					sessionStorage.setItem("dbVerPulArrayAddValue" + i ,
							document.querySelector("#dbVerPulArray" + i).value);
				}
			}
		// 追加の入力フォームを削除している
		} else {
			for (let i = 1; i <= parseInt(sessionStorage.getItem("dbVerPulArrayNum"))
				+ parseInt(sessionStorage.getItem("dbPulDelete")); i++) {
				// 追加したプルダウンのvalue取得
				if (document.querySelector("#dbPulArray" + i) != null) {
					sessionStorage.setItem("dbPulArrayAddValue" + i ,
							document.querySelector("#dbPulArray" + i).value);
				}
				// 追加したプルダウンのバージョンのvalue取得
				if (document.querySelector("#dbVerPulArray" + i) != null) {
					sessionStorage.setItem("dbVerPulArrayAddValue" + i ,
							document.querySelector("#dbVerPulArray" + i).value);
				}
			}
		}
	}
	// DBの追加削除メソッドの呼び出し回数を保持
	if (Math.sign(dbArrayNum) == -1 || Math.sign(sessionStorage.getItem("dbArrayNum")) == 1
			|| sessionStorage.getItem("dbArrayNum") == 0) {
		sessionStorage.setItem("dbArrayNum", parseInt(sessionStorage.getItem("dbArrayNum")) + dbArrayNum);
	} else if (sessionStorage.getItem("dbArrayNum") == null) {
		sessionStorage.setItem("dbArrayNum", dbArrayNum);
	}
	// DB(デフォルト入力フォーム)の情報取得
	sessionStorage.setItem("dbArrayValue", document.querySelector("#dbArray").value);
	// DB(デフォルト入力フォーム)バージョン情報取得
	sessionStorage.setItem("dbVerArrayValue", document.querySelector("#dbVerArray").value);
	// 入力フォームを追加しているかチェック
	if (!(sessionStorage.getItem("dbArrayNum") == null)) {
		// 追加の入力フォームを削除しているかチェック
		// 追加の入力フォームを削除していない
		if (sessionStorage.getItem("dbDelete") == null) {
			for (let i = 1; i <= sessionStorage.getItem("dbArrayNum"); i++) {
				// 追加の入力フォームのDBのvalue取得
				if (document.querySelector("#dbArray" + i) != null) {
					sessionStorage.setItem("dbArrayAddValue" + i,
							document.querySelector("#dbArray" + i).value);
				}
				// 追加の入力フォームのDBバージョンのvalue取得
				if (document.querySelector("#dbVerArray" + i) != null) {
					sessionStorage.setItem("dbVerArrayAddValue" + i,
							document.querySelector("#dbVerArray" + i).value)
				}
			}
		// 追加の入力フォームを削除している
		} else {
			for (let i = 1; i <= parseInt(sessionStorage.getItem("dbArrayNum"))
				+ parseInt(sessionStorage.getItem("dbDelete")); i++) {
				// 追加の入力フォームのDBのvalue取得
				if (document.querySelector("#dbArray" + i) != null) {
					sessionStorage.setItem("dbArrayAddValue" + i,
							document.querySelector("#dbArray" + i).value);
				}
				// 追加の入力フォームのDBバージョンのvalue取得
				if (document.querySelector("#dbVerArray" + i) != null) {
					sessionStorage.setItem("dbVerArrayAddValue" + i,
							document.querySelector("#dbVerArray" + i).value)
				}
			}
		}
	}
	// FW/NWの追加削除メソッドの呼び出し回数を保持
	if (Math.sign(fwNwArrayNum) == -1 || Math.sign(sessionStorage.getItem("fwNwArrayNum")) == 1
			|| sessionStorage.getItem("fwNwArrayNum") == 0) {
		sessionStorage.setItem("fwNwArrayNum", parseInt(sessionStorage.getItem("fwNwArrayNum")) + fwNwArrayNum);
	} else if (sessionStorage.getItem("fwNwArrayNum") == null) {
		sessionStorage.setItem("fwNwArrayNum", fwNwArrayNum);
	}
	// FW/NW(デフォルト入力フォーム)の情報取得
	sessionStorage.setItem("fwNwArrayValue", document.querySelector("#fwNwArray").value);
	// FW/NW(デフォルト入力フォーム)バージョン情報取得
	sessionStorage.setItem("fwNwVerArrayValue", document.querySelector("#fwNwVerArray").value);
	// 入力フォームを追加しているかチェック
	if (sessionStorage.getItem("fwNwArrayNum") != null) {
		// 追加の入力フォームを削除しているかチェック
		// 追加の入力フォームを削除していない
		if (sessionStorage.getItem("fwNwDelete") == null) {
			for (let i = 1; i <= sessionStorage.getItem("fwNwArrayNum"); i++) {
				// 追加の入力フォームのFW/NWのvalue取得
				if (document.querySelector("#fwNwArray" + i) != null) {
					sessionStorage.setItem("fwNwArrayAddValue" + i,
							document.querySelector("#fwNwArray" + i).value);
				}
				// 追加の入力フォームのFW/NWバージョンのvalue取得
				if (document.querySelector("#fwNwVerArray" + i) != null) {
					sessionStorage.setItem("fwNwVerArrayAddValue" + i,
							document.querySelector("#fwNwVerArray" + i).value);
				}
			}
		// 追加の入力フォームを削除していない
		} else {
			console.log(parseInt(sessionStorage.getItem("fwNwArrayNum"))
				+ parseInt(sessionStorage.getItem("fwNwDelete")));
			for (let i = 1; i <= parseInt(sessionStorage.getItem("fwNwArrayNum"))
				+ parseInt(sessionStorage.getItem("fwNwDelete")); i++) {
				// 追加の入力フォームのFW/NWのvalue取得
				if (document.querySelector("#fwNwArray" + i) != null) {
					sessionStorage.setItem("fwNwArrayAddValue" + i,
							document.querySelector("#fwNwArray" + i).value);
				}
				// 追加の入力フォームのFW/NWバージョンのvalue取得
				if (document.querySelector("#fwNwVerArray" + i) != null) {
					sessionStorage.setItem("fwNwVerArrayAddValue" + i,
							document.querySelector("#fwNwVerArray" + i).value);
				}
			}
		}
	}
	// OSプルダウンの追加削除メソッドの呼び出し回数を保持
	if (Math.sign(osVerPulArrayNum) == -1 || Math.sign(sessionStorage.getItem("osVerPulArrayNum")) == 1
			|| sessionStorage.getItem("osVerPulArrayNum") == 0) {
		sessionStorage.setItem("osVerPulArrayNum",
				parseInt(sessionStorage.getItem("osVerPulArrayNum")) + osVerPulArrayNum);
	} else if (sessionStorage.getItem("osVerPulArrayNum") == null) {
		sessionStorage.setItem("osVerPulArrayNum", osVerPulArrayNum);
	}
	// OSのプルダウン(デフォルトプルダウン)の情報取得
	sessionStorage.setItem("osPulArrayValue", document.querySelector("#osPulArray").value);
	// OSのプルダウンのバージョン(デフォルトプルダウンバージョン)の情報取得
	sessionStorage.setItem("osVerPulArrayValue", document.querySelector("#osVerPulArray").value);
	// 入力フォームを追加しているかチェック
	if (sessionStorage.getItem("osVerPulArrayNum") != 0) {
		// 追加の入力フォームを削除しているかチェック
		if (sessionStorage.getItem("osPulDelete") == null) {
			// 追加の入力フォームを削除していない
			for (let i = 1; i <= sessionStorage.getItem("osVerPulArrayNum"); i++) {
				if (document.querySelector("#osPulArray" + i) != null) {
					// 追加したプルダウンのvalue取得
					sessionStorage.setItem("osPulArrayAddValue" + i ,
							document.querySelector("#osPulArray" + i).value);
				}
				if (document.querySelector("#osVerPulArray" + i) != null) {
					// 追加したプルダウンバージョンのvalue取得
					sessionStorage.setItem("osVerPulArrayAddValue" + i ,
							document.querySelector("#osVerPulArray" + i).value);
				}
			}
		// 追加の入力フォームを削除している
		} else {
			for (let i = 1; i <= parseInt(sessionStorage.getItem("osVerPulArrayNum"))
				+ parseInt(sessionStorage.getItem("osPulDelete")); i++) {
				if (document.querySelector("#osPulArray" + i) != null) {
					// 追加したプルダウンのvalue取得
					sessionStorage.setItem("osPulArrayAddValue" + i,
							document.querySelector("#osPulArray" + i).value);
				}
				if (document.querySelector("#osVerPulArray" + i) != null) {
					// 追加したプルダウンバージョンのvalue取得
					sessionStorage.setItem("osVerPulArrayAddValue" + i,
							document.querySelector("#osVerPulArray" + i).value);
				}
			}
		}
	}
	// OSの追加削除メソッドの呼び出し回数を保持
	if (Math.sign(osArrayNum) == -1 || Math.sign(sessionStorage.getItem("osArrayNum")) == 1
			|| sessionStorage.getItem("osArrayNum") == 0) {
		sessionStorage.setItem("osArrayNum", parseInt(sessionStorage.getItem("osArrayNum")) + osArrayNum);
	} else if (sessionStorage.getItem("osArrayNum") == null) {
		sessionStorage.setItem("osArrayNum", osArrayNum);
	}
	// OS入力(デフォルト入力フォーム)の情報取得
	sessionStorage.setItem("osArrayValue", document.querySelector("#osArray").value);
	// OS入力バージョン(デフォルト入力フォーム)の情報取得
	sessionStorage.setItem("osVerArrayValue", document.querySelector("#osVerArray").value);
	// 入力フォームを追加しているかチェック
	if (!(sessionStorage.getItem("osArrayNum") == null)) {
		// 追加の入力フォームを削除しているかチェック
		// 追加の入力フォームを削除していない
		if (sessionStorage.getItem("osDelete") == null) {
			for (let i = 1; i <= sessionStorage.getItem("osArrayNum"); i++) {
				// 追加の入力フォームのOSのvalue取得
				if (document.querySelector("#osArray" + i) != null) {
					sessionStorage.setItem("osArrayAddValue" + i,
							document.querySelector("#osArray" + i).value);
				}
				// 追加の入力フォームのOSバージョンのvalue取得
				if (document.querySelector("#osVerArray" + i) != null) {
					sessionStorage.setItem("osVerArrayAddValue" + i,
							document.querySelector("#osVerArray" + i).value);
				}
			}
		// 追加の入力フォームを削除している
		} else {
			for (let i = 1; i <= parseInt(sessionStorage.getItem("osArrayNum"))
				+ parseInt(sessionStorage.getItem("osDelete")); i++) {
				// 追加の入力フォームのOSのvalue取得
				if (document.querySelector("#osArray" + i) != null) {
					sessionStorage.setItem("osArrayAddValue" + i,
							document.querySelector("#osArray" + i).value);
				}
				// 追加の入力フォームのOSバージョンのvalue取得
				if (document.querySelector("#osVerArray" + i) != null) {
					sessionStorage.setItem("osVerArrayAddValue" + i,
							document.querySelector("#osVerArray" + i).value);
				}
			}
		}
	}
	// 言語の追加削除メソッドの呼び出し回数を保持
	if (Math.sign(languageVerPulArrayNum) == -1 || Math.sign(sessionStorage.getItem("languageVerPulArrayNum")) == 1
			|| sessionStorage.getItem("languageVerPulArrayNum") == 0) {
		sessionStorage.setItem("languageVerPulArrayNum",
				parseInt(sessionStorage.getItem("languageVerPulArrayNum")) + languageVerPulArrayNum);
	} else if (sessionStorage.getItem("languageVerPulArrayNum") == null) {
		sessionStorage.setItem("languageVerPulArrayNum", languageVerPulArrayNum);
	}
	// 言語のプルダウン(デフォルトプルダウン)の情報取得
	sessionStorage.setItem("languagePulArrayValue", document.querySelector("#languagePulArray").value);
	// 言語のプルダウンのバージョン(デフォルトプルダウンバージョン)の情報取得
	sessionStorage.setItem("languageVerPulArrayValue", document.querySelector("#languageVerPulArray").value);
	// 入力フォームを追加しているかチェック
	if (sessionStorage.getItem("languageVerPulArrayNum") != 0) {
		// 追加の入力フォームを削除しているかチェック
		if (sessionStorage.getItem("languagePulDelete") == null) {
			// 追加の入力フォームを削除していない
			for (let i = 1; i <= sessionStorage.getItem("languageVerPulArrayNum"); i++) {
				if (document.querySelector("#languagePulArray" + i) != null) {
					// 追加したプルダウンのvalue取得
					sessionStorage.setItem("languagePulArrayAddValue" + i,
							document.querySelector("#languagePulArray" + i).value);
				}
				if (document.querySelector("#languageVerPulArray" + i) != null) {
					// 追加したプルダウンバージョンのvalue取得
					sessionStorage.setItem("languageVerPulArrayAddValue" + i,
							document.querySelector("#languageVerPulArray" + i).value);
				}
			}
		// 追加の入力フォームを削除している
		} else {
			for (let i = 1; i <= parseInt(sessionStorage.getItem("languageVerPulArrayNum"))
				+ parseInt(sessionStorage.getItem("languagePulDelete")); i++) {
				if (document.querySelector("#languagePulArray" + i) != null) {
					// 追加したプルダウンのvalue取得
					sessionStorage.setItem("languagePulArrayAddValue" + i,
							document.querySelector("#languagePulArray" + i).value);
				}
				if (document.querySelector("#languageVerPulArray" + i) != null) {
					// 追加したプルダウンバージョンのvalue取得
					sessionStorage.setItem("languageVerPulArrayAddValue" + i,
							document.querySelector("#languageVerPulArray" + i).value);
				}
			}
		}
	}
	// 言語の追加削除メソッドの呼び出し回数を保持
	if (Math.sign(languageArrayNum) == -1 || Math.sign(sessionStorage.getItem("languageArrayNum")) == 1
			|| sessionStorage.getItem("languageArrayNum") == 0) {
		sessionStorage.setItem("languageArrayNum",
				parseInt(sessionStorage.getItem("languageArrayNum")) + languageArrayNum);
	} else if (sessionStorage.getItem("languageArrayNum") == null) {
		sessionStorage.setItem("languageArrayNum", languageArrayNum);
	}
	// 言語入力(デフォルト入力フォーム)の情報取得
	sessionStorage.setItem("languageArrayValue", document.querySelector("#languageArray").value);
	// 言語入力バージョン(デフォルト入力フォーム)の情報取得
	sessionStorage.setItem("languageVerArrayValue", document.querySelector("#languageVerArray").value);
	// 入力フォームを追加しているかチェック
	if (!(sessionStorage.getItem("languageArrayNum") == null)) {
		// 追加の入力フォームを削除しているかチェック
		// 追加の入力フォームを削除していない
		if (sessionStorage.getItem("languageDelete") == null) {
			for (let i = 1; i <= sessionStorage.getItem("languageArrayNum"); i++) {
				// 追加の入力フォームの言語のvalue取得
				if (document.querySelector("#languageArray" + i) != null) {
					sessionStorage.setItem("languageArrayAddValue" + i,
							document.querySelector("#languageArray" + i).value);
				}
				// 追加の入力フォームのOSバージョンのvalue取得
				if (document.querySelector("#languageVerArray" + i) != null) {
					sessionStorage.setItem("languageVerArrayAddValue" + i,
							document.querySelector("#languageVerArray" + i).value);
				}
			}
		// 追加の入力フォームを削除している
		} else {
			for (let i = 1; i <= parseInt(sessionStorage.getItem("languageArrayNum"))
				+ parseInt(sessionStorage.getItem("languageDelete")); i++) {
				// 追加の入力フォームのOSのvalue取得
				if (document.querySelector("#languageArray" + i) != null) {
					sessionStorage.setItem("languageArrayAddValue" + i,
							document.querySelector("#languageArray" + i).value);
				}
				// 追加の入力フォームのOSバージョンのvalue取得
				if (document.querySelector("#languageVerArray" + i) != null) {
					sessionStorage.setItem("languageVerArrayAddValue" + i,
							document.querySelector("#languageVerArray" + i).value);
				}
			}
		}
	}
	// その他の追加削除メソッドの呼び出し回数を保持
	if (Math.sign(otherArrayNum) == -1 || Math.sign(sessionStorage.getItem("otherArrayNum")) == 1
			|| sessionStorage.getItem("otherArrayNum") == 0) {
		sessionStorage.setItem("otherArrayNum", parseInt(sessionStorage.getItem("otherArrayNum")) + otherArrayNum);
	} else if (sessionStorage.getItem("otherArrayNum") == null) {
		sessionStorage.setItem("otherArrayNum", otherArrayNum);
	}
	// その他入力(デフォルト入力フォーム)の情報取得
	sessionStorage.setItem("otherArrayValue", document.querySelector("#otherArray").value);
	// その他入力バージョン(デフォルト入力フォーム)の情報取得
	sessionStorage.setItem("otherVerArrayValue", document.querySelector("#otherVerArray").value);
	// 入力フォームを追加しているかチェック
	if (!(sessionStorage.getItem("otherArrayNum") == null)) {
		// 追加の入力フォームを削除しているかチェック
		// 追加の入力フォームを削除していない
		if (sessionStorage.getItem("otherDelete") == null) {
			for (let i = 1; i <= sessionStorage.getItem("otherArrayNum"); i++) {
				// 追加の入力フォームのその他のvalue取得
				if (document.querySelector("#otherArray" + i) != null) {
					sessionStorage.setItem("otherArrayAddValue" + i, document.querySelector("#otherArray" + i).value);
				}
				// 追加の入力フォームのその他バージョンのvalue取得
				if (document.querySelector("#otherVerArray" + i) != null) {
					sessionStorage.setItem("otherVerArrayAddValue" + i, document.querySelector("#otherVerArray" + i).value);
				}
			}
		// 追加の入力フォームを削除している
		} else {
			for (let i = 1; i <= parseInt(sessionStorage.getItem("otherArrayNum"))
				+ parseInt(sessionStorage.getItem("otherDelete")); i++) {
				// 追加の入力フォームのその他のvalue取得
				if (document.querySelector("#otherArray" + i) != null) {
					sessionStorage.setItem("otherArrayAddValue" + i, document.querySelector("#otherArray" + i).value);
				}
				// 追加の入力フォームのその他バージョンのvalue取得
				if (document.querySelector("#otherVerArray" + i) != null) {
					sessionStorage.setItem("otherVerArrayAddValue" + i, document.querySelector("#otherVerArray" + i).value);
				}
			}
		}
	}
});