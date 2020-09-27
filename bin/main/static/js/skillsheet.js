// add_db.addEventListener()メソッドが呼ばれた回数
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

  // 追加した入力欄を消す
  $(document).on("click", ".del", function() {
      var target = $(this).prev("span");
      var del = $(this);
      if (target.parent().children().length > 1) {
          target.remove();
		  del.remove();
      }
  });

  // add_dbクラスのついたボタンが押されたとき、DB欄を増やす
  // セレクトボックス＋テキストボックス＋削除ボタン。を挿入する
  //idが「add_db」の要素を取得
  let add_db = document.getElementById("add_db") || document.createElement('input');

  add_db.addEventListener("click", function(){
	 // idが「box_db」の要素を取得
	 let boxes = document.getElementById("box_db");
	 //「boxes」の要素を複製（コピー）
	 let clone = boxes.cloneNode(true);
	 // 複製した要素を追加
	 $(this).parent().append(clone);
	 $(this).parent().append(
		'<input type="button" class="del delrelative">'
	 );
  });

  // add_db2クラスのついたボタンが押されたとき、DB欄を増やす
  // セレクトボックス＋テキストボックス＋削除ボタン。を挿入する

  //idが「addb_db2」の要素を取得
  let add_db2 = document.getElementById("add_db2") || document.createElement('input');

  add_db2.addEventListener("click", function(){
	  //idが「box_db2」の要素を取得
	  let box_db2 = document.getElementById("box_db2");
	  //「box_db2」の要素を複製（コピー）
	  let clone = box_db2.cloneNode(true);
	  //複製した要素を追加
	  $(this).parent().append(clone);
	  $(this).parent().append(
	     '<input type="button" class="del delrelative">'
	  );
  });

  //add_fwクラスのついたボタンが押されたとき、FW/NW欄を増やす
  // セレクトボックス＋テキストボックス＋削除ボタン。を挿入する

  //idが「add_fw」の要素を取得
  let add_fw = document.getElementById("add_fw") || document.createElement('input');

  add_fw.addEventListener("click", function(){
	  //idが「box_fw」の要素を取得
	  let box_fw = document.getElementById("box_fw");
	  //「box_fw」の要素を複製（コピー）
	  let clone = box_fw.cloneNode(true);
	  //複製した要素を追加
	  $(this).parent().append(clone);
	  $(this).parent().append(
		  '<input type="button" class="del delrelative">'
	  );
  });

  //add_osクラスのついたボタンが押されたとき、OS欄を増やす
  // セレクトボックス＋テキストボックス＋削除ボタン。を挿入する

  //idが「add_os」の要素を取得
  let add_os = document.getElementById("add_os") || document.createElement('input');

  add_os.addEventListener("click", function(){
	  //idが「box_os」の要素を取得
	  let box_os = document.getElementById("box_os");
	  //「box_os」の要素を複製（コピー）
	  let clone = box_os.cloneNode(true);
	  //複製した要素を追加
	  $(this).parent().append(clone);
	  $(this).parent().append(
		  '<input type="button" class="del delrelative">'
	  );
  });

  //add_os2クラスのついたボタンが押されたとき、OS欄を増やす
  // セレクトボックス＋テキストボックス＋削除ボタン。を挿入する

  //idが「add_os2」の要素を取得
  let add_os2 = document.getElementById("add_os2") || document.createElement('input');

  add_os2.addEventListener("click", function(){
	  //idが「box_os2」の要素を取得
	  let box_os2 = document.getElementById("box_os2");
	  //「box_os2」の要素を複製（コピー）
	  let clone = box_os2.cloneNode(true);
	  //複製した要素を追加
	  $(this).parent().append(clone);
	  $(this).parent().append(
		  '<input type="button" class="del delrelative">'
	  );
  });

  //add_langクラスのついたボタンが押されたとき、言語欄を増やす
  // セレクトボックス＋テキストボックス＋削除ボタン。を挿入する

  //idが「add_lang」の要素を取得
  let add_lang = document.getElementById("add_lang") || document.createElement('input');

  add_lang.addEventListener("click", function(){
	  //idが「box_lang」の要素を取得
	  let box_lang = document.getElementById("box_lang");
	  //「box_lang」の要素を複製（コピー）
	  let clone = box_lang.cloneNode(true);
	  //複製した要素を追加
	  $(this).parent().append(clone);
	  $(this).parent().append(
		  '<input type="button" class="del delrelative">'
	  );
  });

//add_lang2クラスのついたボタンが押されたとき、言語欄を増やす
  // セレクトボックス＋テキストボックス＋削除ボタン。を挿入する

  //idが「add_lang2」の要素を取得
  let add_lang2 = document.getElementById("add_lang2") || document.createElement('input');

  add_lang2.addEventListener("click", function(){
	  //idが「box_lang」の要素を取得
	  let box_lang2 = document.getElementById("box_lang2");
	  //「box_lang」の要素を複製（コピー）
	  let clone = box_lang2.cloneNode(true)
	  // add_lang2.addEventListener()メソッドが呼ばれた回数
	  languageArrayNum++;
	  // cloneしたHTMLのidのlanguageArrayにメソッドが呼ばれるプラス1ずつ足していく
	  $(clone).find('#languageArray').attr('id', 'languageArray' +  languageArrayNum);
	  // cloneしたHTMLのidのlanguageVerArrayにメソッドが呼ばれるプラス1ずつ足していく
	  $(clone).find('#languageVerArray').attr('id', 'languageVerArray' +  languageArrayNum);
	  //複製した要素を追加
	  $(this).parent().append(clone);
	  $(this).parent().append(
		  '<input type="button" class="del delrelative">'
	  );
  });


//add_otherクラスのついたボタンが押されたとき、その他欄を増やす
  // セレクトボックス＋テキストボックス＋削除ボタン。を挿入する

  //idが「add_other」の要素を取得
  let add_other = document.getElementById("add_other") || document.createElement('input');

  add_other.addEventListener("click", function(){
	  //idが「box_other」の要素を取得
	  let box_other = document.getElementById("box_other");
	  //「box_other」の要素を複製（コピー）
	  let clone = box_other.cloneNode(true);
	  // add_other.addEventListener()メソッドが呼ばれた回数
	  otherArrayNum++;
	  // cloneしたHTMLのidのotherArrayにメソッドが呼ばれるプラス1ずつ足していく
	  $(clone).find('#otherArray').attr('id', 'otherArray' +  otherArrayNum);
	  // cloneしたHTMLのidのotherVerArrayにメソッドが呼ばれるプラス1ずつ足していく
	  $(clone).find('#otherVerArray').attr('id', 'otherVerArray' +  otherArrayNum);
	  //複製した要素を追加
	  $(this).parent().append(clone);
	  $(this).parent().append(
		  '<input type="button" class="del delrelative">'
	  );
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

// DB OS その他 FW/NW 言語のバリデーションエラーメッセージ変更
function errorMessage() {
	// DBのプルダウンのバージョンの情報取得
	let dbVerPulArray = document.getElementById("dbVerPulArray");
	// DB(プルダウン)エラーメッセージ
	dbVerPulArray.addEventListener('invalid', function(e) {
		if (dbVerPulArray.value.length >= 21) {
			e.target.setCustomValidity("DBのバージョンは20桁以下の範囲で入力してください。");
		} else if (dbVerPulArray.validity.patternMismatch){
	        e.target.setCustomValidity("DBのバージョンは半角英数字のみで入力してください。");
		}
	    dbVerPulArray.addEventListener('input', function(e){
	    	e.target.setCustomValidity('');
	    });
	}, false);
	// DB(プルダウン)入力フォームを追加した場合のエラーメッセージ
	if (!(dbVerPulArrayNum == 0)) {
		for (let i = 1; i <= dbVerPulArrayNum; i++) {
			if (!(document.getElementById("dbVerPulArray" + i) == null)) {
				document.getElementById("dbVerPulArray" + i).addEventListener("invalid", function(e) {
					if (document.getElementById("dbVerPulArray" + i).value.length >= 21) {
						e.target.setCustomValidity("DBのバージョンは20桁以下の範囲で入力してください。");
					} else if (document.getElementById("dbVerPulArray" + i).validity.patternMismatch) {
						e.target.setCustomValidity("DBのバージョンは半角英数字のみで入力してください。");
					}
					document.getElementById("dbVerPulArray" + i).addEventListener('input', function(e){
						e.target.setCustomValidity('');
					});
				},false);
			}
		}
	}
	// DB入力の情報取得
	let dbArray = document.getElementById("dbArray");
	// DB入力エラーメッセージ
	dbArray.addEventListener('invalid', function(e) {
		if (dbArray.value.length >= 21) {
			e.target.setCustomValidity("DBは20桁以下の範囲で入力してください。");
		}
		dbArray.addEventListener('input', function(e){
	    	e.target.setCustomValidity('');
	    });
	}, false);
	// DBの入力フォームを追加した場合のエラーメッセージ
	if (!(dbArrayNum == 0)) {
		for (let i = 1; i <= dbArrayNum; i++) {
			if (!(document.getElementById("dbArray" + i) == null)) {
				document.getElementById("dbArray" + i).addEventListener("invalid", function(e) {
					if (document.getElementById("dbArray" + i).value.length >= 21) {
						e.target.setCustomValidity("DBは20桁以下の範囲で入力してください。");
					}
					document.getElementById("dbArray" + i).addEventListener('input', function(e){
						e.target.setCustomValidity('');
					});
				},false);
			}
		}
	}
	// DB入力バージョンの情報取得
	let dbVerArray = document.getElementById("dbVerArray");
	// DB入力バージョンエラーメッセージ
	dbVerArray.addEventListener('invalid', function(e) {
		if (dbVerArray.value.length >= 21) {
			e.target.setCustomValidity("DBのバージョンは20桁以下の範囲で入力してください。");
		} else if (dbVerArray.validity.patternMismatch){
	        e.target.setCustomValidity("DBのバージョンは半角英数字のみで入力してください。");
		}
		dbVerArray.addEventListener('input', function(e){
	    	e.target.setCustomValidity('');
	    });
	}, false);
	// DBの入力フォームを追加した場合のエラーメッセージ
	if (!(dbArrayNum == 0)) {
		for (let i = 1; i <= dbArrayNum; i++) {
			if (!(document.getElementById("dbVerArray" + i) == null)) {
				document.getElementById("dbVerArray" + i).addEventListener("invalid", function(e) {
					if (document.getElementById("dbVerArray" + i).value.length >= 21) {
						e.target.setCustomValidity("DBのバージョンは20桁以下の範囲で入力してください。");
					} else if (document.getElementById("dbVerArray" + i).validity.patternMismatch){
				        e.target.setCustomValidity("DBのバージョンは半角英数字のみで入力してください。");
					}
					document.getElementById("dbVerArray" + i).addEventListener('input', function(e){
						e.target.setCustomValidity('');
					});
				},false);
			}
		}
	}
	// FW/NW入力の情報取得
	let fwNwArray = document.getElementById("fwNwArray");
	// FW/NW入力エラーメッセージ
	fwNwArray.addEventListener('invalid', function(e) {
		if (fwNwArray.value.length >= 21) {
			e.target.setCustomValidity("FW/NWは20桁以下の範囲で入力してください。");
		}
		fwNwArray.addEventListener('input', function(e){
	    	e.target.setCustomValidity('');
	    });
	}, false);
	// FW/NWの入力フォームを追加した場合のエラーメッセージ
	if (!(fwNwArrayNum == 0)) {
		for (let i = 1; i <= fwNwArrayNum; i++) {
			if (!(document.getElementById("fwNwArray" + i) == null)) {
				document.getElementById("fwNwArray" + i).addEventListener("invalid", function(e) {
					if (document.getElementById("fwNwArray" + i).value.length >= 21) {
						e.target.setCustomValidity("FW/NWは20桁以下の範囲で入力してください。");
					}
					document.getElementById("fwNwArray" + i).addEventListener('input', function(e){
						e.target.setCustomValidity('');
					});
				},false);
			}
		}
	}
	// FW/NW入力バージョンの情報取得
	let fwNwVerArray = document.getElementById("fwNwVerArray");
	// FW/NW入力バージョンエラーメッセージ
	fwNwVerArray.addEventListener('invalid', function(e) {
		if (fwNwVerArray.value.length >= 21) {
			e.target.setCustomValidity("FW/NWのバージョンは20桁以下の範囲で入力してください。");
		} else if (fwNwVerArray.validity.patternMismatch){
	        e.target.setCustomValidity("FW/NWのバージョンは半角英数字のみで入力してください。");
		}
		fwNwVerArray.addEventListener('input', function(e){
	    	e.target.setCustomValidity('');
	    });
	}, false);
	// FW/NWの入力フォームを追加した場合のエラーメッセージ
	if (!(fwNwArrayNum == 0)) {
		for (let i = 1; i <= fwNwArrayNum; i++) {
			if (!(document.getElementById("fwNwVerArray" + i) == null)) {
				document.getElementById("fwNwVerArray" + i).addEventListener("invalid", function(e) {
					if (document.getElementById("fwNwVerArray" + i).value.length >= 21) {
						e.target.setCustomValidity("FW/NWのバージョンは20桁以下の範囲で入力してください。");
					} else if (document.getElementById("fwNwVerArray" + i).validity.patternMismatch){
				        e.target.setCustomValidity("FW/NWのバージョンは半角英数字のみで入力してください。");
					}
					document.getElementById("fwNwVerArray" + i).addEventListener('input', function(e){
						e.target.setCustomValidity('');
					});
				},false);
			}
		}
	}
	// OSのプルダウンのバージョンの情報取得
	let osVerPulArray = document.getElementById("osVerPulArray");
	// OS(プルダウン)エラーメッセージ
	osVerPulArray.addEventListener('invalid', function(e) {
		if (osVerPulArray.value.length >= 21) {
			e.target.setCustomValidity("OSのバージョンは20桁以下の範囲で入力してください。");
		} else if (osVerPulArray.validity.patternMismatch){
	        e.target.setCustomValidity("OSのバージョンは半角英数字のみで入力してください。");
		}
		osVerPulArray.addEventListener('input', function(e){
	    	e.target.setCustomValidity('');
	    });
	}, false);
	// OS(プルダウン)入力フォームを追加した場合のエラーメッセージ
	if (!(osVerPulArrayNum == 0)) {
		for (let i = 1; i <= osVerPulArrayNum; i++) {
			if (!(document.getElementById("osVerPulArray" + i) == null)) {
				document.getElementById("osVerPulArray" + i).addEventListener("invalid", function(e) {
					if (document.getElementById("osVerPulArray" + i).value.length >= 21) {
						e.target.setCustomValidity("OSのバージョンは20桁以下の範囲で入力してください。");
					} else if (document.getElementById("osVerPulArray" + i).validity.patternMismatch) {
						e.target.setCustomValidity("OSのバージョンは半角英数字のみで入力してください。");
					}
					document.getElementById("osVerPulArray" + i).addEventListener('input', function(e){
						e.target.setCustomValidity('');
					});
				},false);
			}
		}
	}
	// os入力の情報取得
	let osArray = document.getElementById("osArray");
	// os入力エラーメッセージ
	osArray.addEventListener('invalid', function(e) {
		if (osArray.value.length >= 21) {
			e.target.setCustomValidity("osは20桁以下の範囲で入力してください。");
		}
		osArray.addEventListener('input', function(e){
	    	e.target.setCustomValidity('');
	    });
	}, false);
	// osの入力フォームを追加した場合のエラーメッセージ
	if (!(osArrayNum == 0)) {
		for (let i = 1; i <= osArrayNum; i++) {
			if (!(document.getElementById("osArray" + i) == null)) {
				document.getElementById("osArray" + i).addEventListener("invalid", function(e) {
					if (document.getElementById("osArray" + i).value.length >= 21) {
						e.target.setCustomValidity("osは20桁以下の範囲で入力してください。");
					}
					document.getElementById("osArray" + i).addEventListener('input', function(e){
						e.target.setCustomValidity('');
					});
				},false);
			}
		}
	}
	// os入力バージョンの情報取得
	let osVerArray = document.getElementById("osVerArray");
	// os入力バージョンエラーメッセージ
	osVerArray.addEventListener('invalid', function(e) {
		if (osVerArray.value.length >= 21) {
			e.target.setCustomValidity("osのバージョンは20桁以下の範囲で入力してください。");
		} else if (osVerArray.validity.patternMismatch){
	        e.target.setCustomValidity("osのバージョンは半角英数字のみで入力してください。");
		}
		osVerArray.addEventListener('input', function(e){
	    	e.target.setCustomValidity('');
	    });
	}, false);
	// osの入力フォームを追加した場合のエラーメッセージ
	if (!(osArrayNum == 0)) {
		for (let i = 1; i <= osArrayNum; i++) {
			if (!(document.getElementById("osVerArray" + i) == null)) {
				document.getElementById("osVerArray" + i).addEventListener("invalid", function(e) {
					if (document.getElementById("osVerArray" + i).value.length >= 21) {
						e.target.setCustomValidity("osのバージョンは20桁以下の範囲で入力してください。");
					} else if (document.getElementById("osVerArray" + i).validity.patternMismatch){
				        e.target.setCustomValidity("osのバージョンは半角英数字のみで入力してください。");
					}
					document.getElementById("osVerArray" + i).addEventListener('input', function(e){
						e.target.setCustomValidity('');
					});
				},false);
			}
		}
	}
	// 言語のプルダウンのバージョンの情報取得
	let languageVerPulArray = document.getElementById("languageVerPulArray");
	// 言語(プルダウン)エラーメッセージ
	languageVerPulArray.addEventListener('invalid', function(e) {
		if (languageVerPulArray.value.length >= 21) {
			e.target.setCustomValidity("言語のバージョンは20桁以下の範囲で入力してください。");
		} else if (languageVerPulArray.validity.patternMismatch){
	        e.target.setCustomValidity("言語のバージョンは半角英数字のみで入力してください。");
		}
		languageVerPulArray.addEventListener('input', function(e){
	    	e.target.setCustomValidity('');
	    });
	}, false);
	// 言語(プルダウン)入力フォームを追加した場合のエラーメッセージ
	if (!(languageVerPulArrayNum == 0)) {
		for (let i = 1; i <= languageVerPulArrayNum; i++) {
			if (!(document.getElementById("languageVerPulArray" + i) == null)) {
				document.getElementById("languageVerPulArray" + i).addEventListener("invalid", function(e) {
					if (document.getElementById("languageVerPulArray" + i).value.length >= 21) {
						e.target.setCustomValidity("言語のバージョンは20桁以下の範囲で入力してください。");
					} else if (document.getElementById("languageVerPulArray" + i).validity.patternMismatch) {
						e.target.setCustomValidity("言語のバージョンは半角英数字のみで入力してください。");
					}
					document.getElementById("languageVerPulArray" + i).addEventListener('input', function(e){
						e.target.setCustomValidity('');
					});
				},false);
			}
		}
	}
	// 言語入力の情報取得
	let languageArray = document.getElementById("languageArray");
	// 言語入力エラーメッセージ
	languageArray.addEventListener('invalid', function(e) {
		if (languageArray.value.length >= 21) {
			e.target.setCustomValidity("言語は20桁以下の範囲で入力してください。");
		}
		languageArray.addEventListener('input', function(e){
	    	e.target.setCustomValidity('');
	    });
	}, false);
	// 言語の入力フォームを追加した場合のエラーメッセージ
	if (!(languageArrayNum == 0)) {
		for (let i = 1; i <= languageArrayNum; i++) {
			if (!(document.getElementById("languageArray" + i) == null)) {
				document.getElementById("languageArray" + i).addEventListener("invalid", function(e) {
					if (document.getElementById("languageArray" + i).value.length >= 21) {
						e.target.setCustomValidity("言語は20桁以下の範囲で入力してください。");
					}
					document.getElementById("languageArray" + i).addEventListener('input', function(e){
						e.target.setCustomValidity('');
					});
				},false);
			}
		}
	}
	// 言語入力バージョンの情報取得
	let languageVerArray = document.getElementById("languageVerArray");
	// 言語入力バージョンエラーメッセージ
	languageVerArray.addEventListener('invalid', function(e) {
		if (languageVerArray.value.length >= 21) {
			e.target.setCustomValidity("言語のバージョンは20桁以下の範囲で入力してください。");
		} else if (languageVerArray.validity.patternMismatch){
	        e.target.setCustomValidity("言語のバージョンは半角英数字のみで入力してください。");
		}
		languageVerArray.addEventListener('input', function(e){
	    	e.target.setCustomValidity('');
	    });
	}, false);
	// 言語の入力フォームを追加した場合のエラーメッセージ
	if (!(languageArrayNum == 0)) {
		for (let i = 1; i <= languageArrayNum; i++) {
			if (!(document.getElementById("languageVerArray" + i) == null)) {
				document.getElementById("languageVerArray" + i).addEventListener("invalid", function(e) {
					if (document.getElementById("languageVerArray" + i).value.length >= 21) {
						e.target.setCustomValidity("言語のバージョンは20桁以下の範囲で入力してください。");
					} else if (document.getElementById("languageVerArray" + i).validity.patternMismatch){
				        e.target.setCustomValidity("言語のバージョンは半角英数字のみで入力してください。");
					}
					document.getElementById("languageVerArray" + i).addEventListener('input', function(e){
						e.target.setCustomValidity('');
					});
				},false);
			}
		}
	}
	// その他入力の情報取得
	let otherArray = document.getElementById("otherArray");
	// その他入力エラーメッセージ
	otherArray.addEventListener('invalid', function(e) {
		if (otherArray.value.length >= 21) {
			e.target.setCustomValidity("その他は20桁以下の範囲で入力してください。");
		}
		otherArray.addEventListener('input', function(e){
	    	e.target.setCustomValidity('');
	    });
	}, false);
	// その他の入力フォームを追加した場合のエラーメッセージ
	if (!(otherArrayNum == 0)) {
		for (let i = 1; i <= otherArrayNum; i++) {
			if (!(document.getElementById("otherArray" + i) == null)) {
				document.getElementById("otherArray" + i).addEventListener("invalid", function(e) {
					if (document.getElementById("otherArray" + i).value.length >= 21) {
						e.target.setCustomValidity("その他は20桁以下の範囲で入力してください。");
					}
					document.getElementById("otherArray" + i).addEventListener('input', function(e){
						e.target.setCustomValidity('');
					});
				},false);
			}
		}
	}
	// その他入力バージョンの情報取得
	let otherVerArray = document.getElementById("otherVerArray");
	// その他入力バージョンエラーメッセージ
	otherVerArray.addEventListener('invalid', function(e) {
		if (otherVerArray.value.length >= 21) {
			e.target.setCustomValidity("その他のバージョンは20桁以下の範囲で入力してください。");
		} else if (otherVerArray.validity.patternMismatch){
	        e.target.setCustomValidity("その他のバージョンは半角英数字のみで入力してください。");
		}
		otherVerArray.addEventListener('input', function(e){
	    	e.target.setCustomValidity('');
	    });
	}, false);
	// その他の入力フォームを追加した場合のエラーメッセージ
	if (!(otherArrayNum == 0)) {
		for (let i = 1; i <= otherArrayNum; i++) {
			if (!(document.getElementById("otherVerArray" + i) == null)) {
				document.getElementById("otherVerArray" + i).addEventListener("invalid", function(e) {
					if (document.getElementById("otherVerArray" + i).value.length >= 21) {
						e.target.setCustomValidity("その他のバージョンは20桁以下の範囲で入力してください。");
					} else if (document.getElementById("otherVerArray" + i).validity.patternMismatch){
				        e.target.setCustomValidity("その他のバージョンは半角英数字のみで入力してください。");
					}
					document.getElementById("otherVerArray" + i).addEventListener('input', function(e){
						e.target.setCustomValidity('');
					});
				},false);
			}
		}
	}
}
