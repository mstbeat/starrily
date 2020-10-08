document.addEventListener("DOMContentLoaded", function() {
	// DBプルダウン追加入力フォームを再構築
	// DBプルダウン追加入力フォームの数取得
	let dbVerPulArrayNum = sessionStorage.getItem("dbVerPulArrayNum");
	// dbPulArray(デフォルトのプルダウン)のvalue取得
	let dbPulArrayValue = sessionStorage.getItem("dbPulArrayValue");
	// dbVerPulArray(デフォルトのプルダウンバージョン)のvalue取得
	let dbVerPulArrayValue = sessionStorage.getItem("dbVerPulArrayValue");
	// セッションのキーをインクリメントする
	let dbPulSe = 1;
	// 追加DB入力フォームのid
	let dbPulId = 1;
	// 追加DB入力フォームプルダウンバージョンのid
	let dbPulVerId = 1;
	// 入力フォームを追加しているかチェック
	if (dbVerPulArrayNum != null) {
		// 入力フォーム再構築
		for (let i = 1; i <= dbVerPulArrayNum; i++) {
			// idが「add_db」の要素を取得
			let add_db = document.querySelector("#add_db");
			//idが「box_db」の要素を取得
			let boxes = document.querySelector("#box_db");
			//「boxes」の要素を複製（コピー）
			let clone = boxes.cloneNode(true);
			// cloneしたHTMLのidのdbPulArrayにメソッドが呼ばれるプラス1ずつ足していく
			$(clone).find("#dbPulArray").attr("id", "dbPulArray" + i);
			// cloneしたHTMLのidのdbVerPulArrayにメソッドが呼ばれるプラス1ずつ足していく
			$(clone).find('#dbVerPulArray').attr('id', 'dbVerPulArray' + i);
			//複製した要素を追加
			$(add_db).parent().append(clone);
			$(add_db).parent().append(
				'<input type="button" class="del delrelative" id="dbPul">'
			 );
		}

		// dbPulArray(デフォルトであるプルダウン)のvalueを書き換え
		for(let i = 0; i < document.querySelector("#dbPulArray").options.length; i++) {
		    if (document.querySelector("#dbPulArray").options[i].label == dbPulArrayValue) {
				document.querySelector("#dbPulArray").selectedIndex = i;
		    }
		}
		// dbVerPulArray(デフォルトのDBプルダウンバージョン)のvalueを書き換え
		document.querySelector("#dbVerPulArray").defaultValue = dbVerPulArrayValue;
		// dbPulArray(追加したプルダウン)のvalueを再セット
		// 追加入力フォームを削除していない場合
		if (sessionStorage.getItem("dbPulDelete") == null) {
			for(let i = 0; i < dbVerPulArrayNum; i++) {
				// 追加したdbPulArrayのvalue取得
				let dbPulArrayAddValue = sessionStorage.getItem("dbPulArrayAddValue" + dbPulSe);
				// 追加したプルダウンのvalueを書き換え
				for (let i = 0; i < document.querySelector("#dbPulArray").options.length; i++) {
					if (document.querySelector("#dbPulArray").options[i].label == dbPulArrayAddValue) {
						document.querySelector("#dbPulArray" + dbPulId).selectedIndex = i;
						dbPulId++;
					}
				}
				// セッション削除
				sessionStorage.removeItem("dbPulArrayAddValue" + dbPulSe)
				dbPulSe++;
			}
			for (let i = 1; i <= dbVerPulArrayNum; i++) {
				// dbVerPulArray(追加したDBプルダウンバージョン)のvalue取得
				let dbVerPulArrayAddValue = sessionStorage.getItem("dbVerPulArrayAddValue" + i)
				// dbVerPulArray(追加したDBプルダウンバージョン)のvalue書き換え
				document.querySelector("#dbVerPulArray" + i).value = dbVerPulArrayAddValue;
				// セッション削除
				sessionStorage.removeItem("dbVerPulArrayAddValue" + i);
			}
		// 追加入力フォームを削除している場合
		} else {
			for(let i = 0; i < parseInt(dbVerPulArrayNum) + parseInt(sessionStorage.getItem("dbPulDelete")); i++) {
				// 追加したdbPulArrayのvalue取得
				let dbPulArrayAddValue = sessionStorage.getItem("dbPulArrayAddValue" + dbPulSe);
				// 追加したプルダウンのvalueを書き換え
				for (let i = 0; i < document.querySelector("#dbPulArray").options.length; i++) {
					if (document.querySelector("#dbPulArray").options[i].label == dbPulArrayAddValue) {
						document.querySelector("#dbPulArray" + dbPulId).selectedIndex = i;
						dbPulId++;
					}
				}
				// セッション削除
				sessionStorage.removeItem("dbPulArrayAddValue" + dbPulSe)
				dbPulSe++;
				for (let i = 1; i <= parseInt(dbVerPulArrayNum) + parseInt(sessionStorage.getItem("dbPulDelete")); i++) {
					// dbVerPulArray(追加したDBプルダウンバージョン)のvalue取得
					let dbVerPulArrayAddValue = sessionStorage.getItem("dbVerPulArrayAddValue" + i)
					if (dbVerPulArrayAddValue != null) {
						document.querySelector("#dbVerPulArray" + dbPulVerId).value = dbVerPulArrayAddValue;
						dbPulVerId++;
					}
					// セッション削除
					sessionStorage.removeItem("dbVerPulArrayAddValue" + i);
				}
			}
		}
	}
	// セッション削除
	sessionStorage.removeItem("dbVerPulArrayValue");
	sessionStorage.removeItem("dbPulArrayValue");
	sessionStorage.removeItem("dbPulDelete");

	// DB追加入力フォームを再構築
	// DB追加入力フォームの数取得
	let dbArrayNum = sessionStorage.getItem("dbArrayNum")
	// DB(デフォルト入力フォーム)情報取得
	let dbArrayValue = sessionStorage.getItem("dbArrayValue")
	// DB(デフォルト入力フォーム)バージョン情報取得
	let dbVerArrayValue = sessionStorage.getItem("dbVerArrayValue")
	// DB入力フォームの削除回数
	let dbDelete = sessionStorage.getItem("dbDelete");
	// 追加DB入力フォームのId
	let dbId = 1;
	// 追加DBバージョン入力フォームのId
	let dbVerId = 1;
	// 入力フォームを追加しているかチェック
	if (dbArrayNum != null) {
		// 入力フォーム再構築
		for (let i = 1; i <= dbArrayNum; i++) {
			 //idが「addb_db2」の要素を取得
			let add_db2 = document.getElementById("add_db2");
			//idが「box_db2」の要素を取得
			let box_db2 = document.querySelector("#box_db2");
			//「box_db2」の要素を複製（コピー）
			let clone = box_db2.cloneNode(true);
			// cloneしたHTMLのidのdbArrayにメソッドが呼ばれるプラス1ずつ足していく
			$(clone).find('#dbArray').attr('id', 'dbArray' + i);
			// cloneしたHTMLのidのdbVerArrayにメソッドが呼ばれるプラス1ずつ足していく
			$(clone).find('#dbVerArray').attr('id', 'dbVerArray' + i);
			//複製した要素を追加
			$(add_db2).parent().append(clone);
			$(add_db2).parent().append(
			   '<input type="button" class="del delrelative" id="db">'
			);
		}
		// dbArray(デフォルトのDB)のvalueを書き換え
		document.querySelector("#dbArray").defaultValue = dbArrayValue;
		// dbVerArray(デフォルトのDBバージョン)のvalueを書き換え
		document.querySelector("#dbVerArray").defaultValue = dbVerArrayValue;
		// 追加した入力フォームのvalueを再セット
		// 入力フォームを削除していない場合
		if (dbDelete == null) {
			for (let i = 1; i <= dbArrayNum; i++) {
				// dbArray(追加したDB)のvalue取得
				let dbArrayAddValue = sessionStorage.getItem("dbArrayAddValue" + i);
				document.querySelector("#dbArray" + i).value = dbArrayAddValue;
				// dbVerArray(追加したDBバージョン)のvalue取得
				let dbVerArrayAddValue = sessionStorage.getItem("dbVerArrayAddValue" + i);
				document.querySelector("#dbVerArray" + i).value = dbVerArrayAddValue;
				// セッション削除
				sessionStorage.removeItem("dbArrayAddValue" + i);
				sessionStorage.removeItem("dbVerArrayAddValue" + i);
			}
		// 入力フォームを削除している場合
		} else {
			for (let i = 1; i <= parseInt(dbArrayNum) + parseInt(dbDelete); i++) {
				// dbArray(追加したDB)のvalue取得
				let dbArrayAddValue = sessionStorage.getItem("dbArrayAddValue" + i);
				if (dbArrayAddValue != null) {
					document.querySelector("#dbArray" + dbId).value = dbArrayAddValue;
					dbId++;
				}
				// dbVerArray(追加したDBバージョン)のvalue取得
				let dbVerArrayAddValue = sessionStorage.getItem("dbVerArrayAddValue" + i);
				if (dbVerArrayAddValue != null) {
					document.querySelector("#dbVerArray" + dbVerId).value = dbVerArrayAddValue;
					dbVerId++;
				}
				// セッション削除
				sessionStorage.removeItem("dbArrayAddValue" + i);
				sessionStorage.removeItem("dbVerArrayAddValue" + i);
			}
		}
	}
	// セッション削除
	sessionStorage.removeItem("dbArrayValue");
	sessionStorage.removeItem("dbVerArrayValue");
	sessionStorage.removeItem("dbDelete");

	// FW/NW追加入力フォームを再構築
	// FW/NWの追加の入力フォームの数
	let fwNwArrayNum = sessionStorage.getItem("fwNwArrayNum");
	// FW/NW入力フォームの削除回数
	let fwNwDelete = sessionStorage.getItem("fwNwDelete");
	// FW/NW(デフォルト入力フォーム)情報取得
	let fwNwArrayValue = sessionStorage.getItem("fwNwArrayValue");
	// FW/NW(デフォルト入力フォーム)バージョン情報取得
	let fwNwVerArrayValue = sessionStorage.getItem("fwNwVerArrayValue");
	// 追加FW/NW入力フォームのId
	let fwNwId = 1;
	// 追加FW/NWバージョン入力フォームのId
	let fwNwVerId = 1;
	// 入力フォームを追加しているかチェック
	if (fwNwArrayNum != null) {
		// 入力フォーム再構築
		for (let i = 1; i <= fwNwArrayNum; i++) {
			//idが「add_fw」の要素を取得
			let add_fw = document.querySelector("#add_fw");
			 //idが「box_fw」の要素を取得
			let box_fw = document.querySelector("#box_fw");
			//「box_fw」の要素を複製（コピー）
			let clone = box_fw.cloneNode(true);
			// cloneしたHTMLのidのfwNwArrayにメソッドが呼ばれるプラス1ずつ足していく
			$(clone).find("#fwNwArray").attr("id", "fwNwArray" + i);
			// cloneしたHTMLのidのfwNwVerArrayにメソッドが呼ばれるプラス1ずつ足していく
			$(clone).find("#fwNwVerArray").attr("id", "fwNwVerArray" + i);
			//複製した要素を追加
			$(add_fw).parent().append(clone);
			$(add_fw).parent().append(
				'<input type="button" class="del delrelative" id="fwNw" >'
			);
		}
		// fwNwArray(デフォルトのFW/NW)のvalueを書き換え
		document.querySelector("#fwNwArray").defaultValue = fwNwArrayValue;
		// fwNwVerArray(デフォルトのFW/NWバージョン)のvalueを書き換え
		document.querySelector("#fwNwVerArray").defaultValue = fwNwVerArrayValue;
		// 追加した入力フォームのvalueを再セット
		// 入力フォームを削除していない場合
		if (fwNwDelete == null) {
			for (let i = 1; i <= fwNwArrayNum; i++) {
				// fwNwArray(追加したFW/NW)のvalue取得
				let fwNwArrayAddValue = sessionStorage.getItem("fwNwArrayAddValue" + i);
				document.querySelector("#fwNwArray" + i).value = fwNwArrayAddValue;
				// fwNwVerArray(追加したFW/NWバージョン)のvalue取得
				let fwNwVerArrayAddValue = sessionStorage.getItem("fwNwVerArrayAddValue" + i);
				document.querySelector("#fwNwVerArray" + i).value = fwNwVerArrayAddValue;
				// セッション削除
				sessionStorage.removeItem("fwNwArrayAddValue" + i);
				sessionStorage.removeItem("fwNwVerArrayAddValue" + i);
			}
		// 入力フォームを削除している場合
		} else {
			for (let i = 1; i <= parseInt(fwNwArrayNum) + parseInt(fwNwDelete); i++) {
				// fwNwArray(追加したFW/NW)のvalue取得
				let fwNwArrayAddValue = sessionStorage.getItem("fwNwArrayAddValue" + i);
				if (fwNwArrayAddValue != null) {
					document.querySelector("#fwNwArray" + fwNwId).value = fwNwArrayAddValue;
					fwNwId++;
				}
				// fwNwVerArray(追加したFW/NWバージョン)のvalue取得
				let fwNwVerArrayAddValue = sessionStorage.getItem("fwNwVerArrayAddValue" + i);
				if (fwNwVerArrayAddValue != null) {
					document.querySelector("#fwNwVerArray" + fwNwVerId).value = fwNwVerArrayAddValue;
					fwNwVerId++;
				}
				// セッション削除
				sessionStorage.removeItem("fwNwArrayAddValue" + i);
				sessionStorage.removeItem("fwNwVerArrayAddValue" + i);
			}
		}
	}
	// セッション削除
	sessionStorage.removeItem("fwNwArrayValue");
	sessionStorage.removeItem("fwNwVerArrayValue");
	sessionStorage.removeItem("fwNwDelete");


	// OSプルダウン追加入力フォームを再構築
	// OSプルダウン追加入力フォームの数取得
	let osVerPulArrayNum = sessionStorage.getItem("osVerPulArrayNum");
	// osPulArray(デフォルトのプルダウン)のvalue取得
	let osPulArrayValue = sessionStorage.getItem("osPulArrayValue");
	// osVerPulArray(デフォルトのプルダウンバージョン)のvalue取得
	let osVerPulArrayValue = sessionStorage.getItem("osVerPulArrayValue");
	// セッションのキーをインクリメントする
	let osPulSe = 1;
	// 追加OS入力フォームのid
	let osPulId = 1;
	// 追加OS入力フォームプルダウンバージョンのid
	let osPulVerId = 1;
	// 入力フォームを追加しているかチェック
	if (osVerPulArrayNum != null) {
		// 入力フォーム再構築
		for (let i = 1; i <= osVerPulArrayNum; i++) {
			// idが「add_os」の要素を取得
			let add_os = document.querySelector("#add_os");
			//idが「box_os」の要素を取得
			let boxes = document.querySelector("#box_os");
			//「boxes」の要素を複製（コピー）
			let clone = boxes.cloneNode(true);
			// cloneしたHTMLのidのosPulArrayにメソッドが呼ばれるプラス1ずつ足していく
			$(clone).find("#osPulArray").attr("id", "osPulArray" + i);
			// cloneしたHTMLのidのosVerPulArrayにメソッドが呼ばれるプラス1ずつ足していく
			$(clone).find("#osVerPulArray").attr("id", "osVerPulArray" + i);
			//複製した要素を追加
			$(add_os).parent().append(clone);
			$(add_os).parent().append(
				'<input type="button" class="del delrelative" id="osPul">'
			 );
		}
		// osPulArray(デフォルトであるプルダウン)のvalueを書き換え
		for(let i = 0; i < document.querySelector("#osPulArray").options.length; i++) {
		    if (document.querySelector("#osPulArray").options[i].label == osPulArrayValue) {
				document.querySelector("#osPulArray").selectedIndex = i;
		    }
		}
		// osVerPulArray(デフォルトのOSプルダウンバージョン)のvalueを書き換え
		document.querySelector("#osVerPulArray").defaultValue = osVerPulArrayValue;
		// dbPulArray(追加したプルダウン)のvalueを書き換え
		// 追加の入力フォームを削除していない
		if (sessionStorage.getItem("osPulDelete") == null) {
			for(let i = 0; i < osVerPulArrayNum; i++) {
				// 追加したosPulArrayのvalue取得
				let osPulArrayAddValue = sessionStorage.getItem("osPulArrayAddValue" + osPulSe);
				// 追加したプルダウンのvalueを書き換え
				for (let i = 0; i < document.querySelector("#osPulArray").options.length; i++) {
					if (document.querySelector("#osPulArray").options[i].label == osPulArrayAddValue) {
						document.querySelector("#osPulArray" + osPulId).selectedIndex = i;
						osPulId++;
					}
				}
				// セッション削除
				sessionStorage.removeItem("osPulArrayAddValue" + osPulSe)
				osPulSe++;
			}
			for (let i = 1; i <= osVerPulArrayNum; i++) {
				// osVerPulArray(追加したOSプルダウンバージョン)のvalue取得
				let osVerPulArrayAddValue = sessionStorage.getItem("osVerPulArrayAddValue" + i);
				// osVerPulArray(追加したOSプルダウンバージョン)のvalue書き換え
				document.querySelector("#osVerPulArray" + i).value = osVerPulArrayAddValue;
				// セッション削除
				sessionStorage.removeItem("osVerPulArrayAddValue" + i);
			}
		// 追加の入力フォームを削除している
		} else {
			for(let i = 0; i < parseInt(osVerPulArrayNum) + parseInt(sessionStorage.getItem("osPulDelete")); i++) {
				// 追加したosPulArrayのvalue取得
				let osPulArrayAddValue = sessionStorage.getItem("osPulArrayAddValue" + osPulSe);
				// 追加したプルダウンのvalueを書き換え
				for (let i = 0; i < document.querySelector("#osPulArray").options.length; i++) {
					if (document.querySelector("#osPulArray").options[i].label == osPulArrayAddValue) {
						document.querySelector("#osPulArray" + osPulId).selectedIndex = i;
						osPulId++;
					}
				}
				// セッション削除
				sessionStorage.removeItem("osPulArrayAddValue" + osPulSe)
				osPulSe++;
			}
			for (let i = 1; i <= parseInt(osVerPulArrayNum) + parseInt(sessionStorage.getItem("osPulDelete")); i++) {
				// osVerPulArray(追加したOSプルダウンバージョン)のvalue取得
				let osVerPulArrayAddValue = sessionStorage.getItem("osVerPulArrayAddValue" + i);
				if (osVerPulArrayAddValue != null) {
					document.querySelector("#osVerPulArray" + osPulVerId).value = osVerPulArrayAddValue;
					osPulVerId++;
				}
				// セッション削除
				sessionStorage.removeItem("osVerPulArrayAddValue" + i);
			}
		}
	}
	// セッション削除
	sessionStorage.removeItem("osPulArrayValue");
	sessionStorage.removeItem("osVerPulArrayValue")
	sessionStorage.removeItem("osPulDelete");

	// OS追加入力フォームを再構築
	// OSの追加の入力フォームの数
	let osArrayNum = sessionStorage.getItem("osArrayNum");
	// OS入力(デフォルト入力フォーム)の情報取得
	let osArrayValue = sessionStorage.getItem("osArrayValue");
	// OS入力バージョン(デフォルト入力フォーム)の情報取得
	let osVerArrayValue = sessionStorage.getItem("osVerArrayValue");
	// OS入力フォームの削除回数
	let osDelete = sessionStorage.getItem("osDelete");
	// 追加OS入力フォームのId
	let osId = 1;
	// 追加OSバージョン入力フォームのId
	let osVerId = 1;
	// 入力フォームを追加しているかチェック
	if (osArrayNum != null) {
		// 入力フォーム再構築
		for (let i = 1; i <= osArrayNum; i++) {
			//idが「add_os2」の要素を取得
			let add_os2 = document.querySelector("#add_os2");
			 //idが「box_os2」の要素を取得
			let box_os2 = document.querySelector("#box_os2");
			//「box_os2」の要素を複製（コピー）
			let clone = box_os2.cloneNode(true);
			// cloneしたHTMLのidのosArrayにメソッドが呼ばれるプラス1ずつ足していく
			$(clone).find("#osArray").attr("id", "osArray" + i);
			// cloneしたHTMLのidのosVerArrayにメソッドが呼ばれるプラス1ずつ足していく
			$(clone).find("#osVerArray").attr("id", "osVerArray" + i);
			//複製した要素を追加
			$(add_os2).parent().append(clone);
			$(add_os2).parent().append(
				'<input type="button" class="del delrelative" id="os" >'
			);
		}
		// osArray(デフォルトのOS)のvalueを書き換え
		document.querySelector("#osArray").defaultValue = osArrayValue;
		// osVerArray(デフォルトのOSバージョン)のvalueを書き換え
		document.querySelector("#osVerArray").defaultValue = osVerArrayValue;
		// 追加した入力フォームのvalueを再セット
		// 入力フォームを削除していない場合
		if (osDelete == null) {
			for (let i = 1; i <= osArrayNum; i++) {
				// osArray(追加したOS)のvalue取得
				let osArrayAddValue = sessionStorage.getItem("osArrayAddValue" + i);
				document.querySelector("#osArray" + i).value = osArrayAddValue;
				// osVerArray(追加したOSバージョン)のvalue取得
				let osVerArrayAddValue = sessionStorage.getItem("osVerArrayAddValue" + i);
				document.querySelector("#osVerArray" + i).value = osVerArrayAddValue;
				// セッション削除
				sessionStorage.removeItem("osArrayAddValue" + i);
				sessionStorage.removeItem("osVerArrayAddValue" + i);
			}
		// 入力フォームを削除している場合
		} else {
			for (let i = 1; i <= parseInt(osArrayNum) + parseInt(osDelete); i++) {
				// osArray(追加したOS)のvalue取得
				let osArrayAddValue = sessionStorage.getItem("osArrayAddValue" + i);
				if (osArrayAddValue != null) {
					document.querySelector("#osArray" + osId).value = osArrayAddValue;
					osId++;
				}
				// osVerArray(追加したOSバージョン)のvalue取得
				let osVerArrayAddValue = sessionStorage.getItem("osVerArrayAddValue" + i);
				console.log(osVerArrayAddValue);
				if (osVerArrayAddValue != null) {
					document.querySelector("#osVerArray" + osVerId).value = osVerArrayAddValue;
					osVerId++;
				}
				// セッション削除
				sessionStorage.removeItem("osArrayAddValue" + i);
				sessionStorage.removeItem("osVerArrayAddValue" + i);
			}
		}
	}
	// セッション削除
	sessionStorage.removeItem("osArrayValue");
	sessionStorage.removeItem("osVerArrayValue")
	sessionStorage.removeItem("osDelete");

	// 言語プルダウン追加入力フォームを再構築
	// 言語プルダウン追加入力フォームの数取得
	let languageVerPulArrayNum = sessionStorage.getItem("languageVerPulArrayNum");
	// 言語のプルダウン(デフォルトプルダウン)の情報取得
	let languagePulArrayValue = sessionStorage.getItem("languagePulArrayValue");
	// 言語のプルダウンのバージョン(デフォルトプルダウンバージョン)の情報取得
	let languageVerPulArrayValue = sessionStorage.getItem("languageVerPulArrayValue");
	// セッションのキーをインクリメントする
	let languagePulSe = 1;
	// 追加OS入力フォームのid
	let languagePulId = 1;
	// 追加OS入力フォームプルダウンバージョンのid
	let languagePulVerId = 1;
	// 入力フォームを追加しているかチェック
	if (languageVerPulArrayNum != null) {
		// 入力フォーム再構築
		for (let i = 1; i <= languageVerPulArrayNum; i++) {
			// idが「add_lang」の要素を取得
			let add_lang = document.querySelector("#add_lang");
			//idが「box_lang」の要素を取得
			let boxes = document.querySelector("#box_lang");
			//「boxes」の要素を複製（コピー）
			let clone = boxes.cloneNode(true);
			// cloneしたHTMLのidのlanguagePulArrayにメソッドが呼ばれるプラス1ずつ足していく
			$(clone).find("#languagePulArray").attr("id", "languagePulArray" + i);
			// cloneしたHTMLのidのlanguageVerPulArrayにメソッドが呼ばれるプラス1ずつ足していく
			$(clone).find("#languageVerPulArray").attr("id", "languageVerPulArray" + i);
			//複製した要素を追加
			$(add_lang).parent().append(clone);
			$(add_lang).parent().append(
				'<input type="button" class="del delrelative" id="languagePul">'
			 );
		}
		// languagePulArray(デフォルトであるプルダウン)のvalueを書き換え
		for(let i = 0; i < document.querySelector("#languagePulArray").options.length; i++) {
		    if (document.querySelector("#languagePulArray").options[i].label == languagePulArrayValue) {
				document.querySelector("#languagePulArray").selectedIndex = i;
		    }
		}
		// languageVerPulArray(デフォルトの言語プルダウンバージョン)のvalueを書き換え
		document.querySelector("#languageVerPulArray").defaultValue = languageVerPulArrayValue;

		// languagePulArray(追加したプルダウン)のvalueを書き換え
		// 追加の入力フォームを削除していない
		if (sessionStorage.getItem("languagePulDelete") == null) {
			for(let i = 0; i < languageVerPulArrayNum; i++) {
				// 追加したlanguagePulArrayのvalue取得
				let languagePulArrayAddValue = sessionStorage.getItem("languagePulArrayAddValue" + languagePulSe);
				// 追加したプルダウンのvalueを書き換え
				for (let i = 0; i < document.querySelector("#languagePulArray").options.length; i++) {
					if (document.querySelector("#languagePulArray").options[i].label == languagePulArrayAddValue) {
						document.querySelector("#languagePulArray" + languagePulId).selectedIndex = i;
						languagePulId++;
					}
				}
				// セッション削除
				sessionStorage.removeItem("languagePulArrayAddValue" + languagePulSe)
				languagePulSe++;
			}
			for (let i = 1; i <= languageVerPulArrayNum; i++) {
				// languageVerPulArray(追加した言語バージョン)のvalue取得
				let languageVerPulArrayAddValue = sessionStorage.getItem("languageVerPulArrayAddValue" + i);
				document.querySelector("#languageVerPulArray" + i).value = languageVerPulArrayAddValue;
				// セッション削除
				sessionStorage.removeItem("languageVerPulArrayAddValue" + i);
			}
		// 追加の入力フォームを削除している
		} else {
			for(let i = 0; i < parseInt(languageVerPulArrayNum) + parseInt(sessionStorage.getItem("languagePulDelete")); i++) {
				// 追加したlanguagePulArrayのvalue取得
				let languagePulArrayAddValue = sessionStorage.getItem("languagePulArrayAddValue" + languagePulSe);
				// 追加したプルダウンのvalueを書き換え
				for (let i = 0; i < document.querySelector("#languagePulArray").options.length; i++) {
					if (document.querySelector("#languagePulArray").options[i].label == languagePulArrayAddValue) {
						document.querySelector("#languagePulArray" + languagePulId).selectedIndex = i;
						languagePulId++;
					}
				}
				// セッション削除
				sessionStorage.removeItem("languagePulArrayAddValue" + languagePulSe)
				languagePulSe++;
			}
			for (let i = 1; i <= parseInt(languageVerPulArrayNum) + parseInt(sessionStorage.getItem("languagePulDelete")); i++) {
				// languageVerPulArray(追加した言語バージョン)のvalue取得
				let languageVerPulArrayAddValue = sessionStorage.getItem("languageVerPulArrayAddValue" + i);
				if (languageVerPulArrayAddValue != null) {
					document.querySelector("#languageVerPulArray" + languagePulVerId).value = languageVerPulArrayAddValue;
					languagePulVerId++;
				}
				// セッション削除
				sessionStorage.removeItem("languageVerPulArrayAddValue" + i);
			}
		}
	}
	// セッション削除
	sessionStorage.removeItem("languagePulArrayValue");
	sessionStorage.removeItem("languageVerPulArrayValue")
	sessionStorage.removeItem("languagePulDelete");

	// 言語追加入力フォームを再構築
	// 言語の追加の入力フォームの数
	let languageArrayNum = sessionStorage.getItem("languageArrayNum");
	// 言語入力(デフォルト入力フォーム)の情報取得
	let languageArrayValue = sessionStorage.getItem("languageArrayValue");
	// 言語入力バージョン(デフォルト入力フォーム)の情報取得
	let languageVerArrayValue = sessionStorage.getItem("languageVerArrayValue");
	// 言語入力フォームの削除回数
	let languageDelete = sessionStorage.getItem("languageDelete");
	// 追加言語入力フォームのId
	let languageId = 1;
	// 追加言語バージョン入力フォームのId
	let languageVerId = 1;
	// 入力フォーム再構築
	// 入力フォームを追加しているかチェック
	if (languageArrayNum != null) {
		for (let i = 1; i <= languageArrayNum; i++) {
			//idが「add_lang2」の要素を取得
			let add_lang2 = document.querySelector("#add_lang2");
			 //idが「box_lang2」の要素を取得
			let box_lang2 = document.querySelector("#box_lang2");
			//「box_lang2」の要素を複製（コピー）
			let clone = box_lang2.cloneNode(true);
			// cloneしたHTMLのidのlanguageArrayにメソッドが呼ばれるプラス1ずつ足していく
			$(clone).find("#languageArray").attr("id", "languageArray" + i);
			// cloneしたHTMLのidのlanguageVerArrayにメソッドが呼ばれるプラス1ずつ足していく
			$(clone).find("#languageVerArray").attr("id", "languageVerArray" + i);
			//複製した要素を追加
			$(add_lang2).parent().append(clone);
			$(add_lang2).parent().append(
				'<input type="button" class="del delrelative" id="language" >'
			);
		}
		// languageArray(デフォルトの言語)のvalueを書き換え
		document.querySelector("#languageArray").defaultValue = languageArrayValue;
		// languageVerArray(デフォルトの言語バージョン)のvalueを書き換え
		document.querySelector("#languageVerArray").defaultValue = languageVerArrayValue;
		// 追加した入力フォームのvalueを再セット
		// 入力フォームを削除していない場合
		if (languageDelete == null) {
			for (let i = 1; i <= languageArrayNum; i++) {
				// languageArray(追加した言語)のvalue取得
				let languageArrayAddValue = sessionStorage.getItem("languageArrayAddValue" + i);
				document.querySelector("#languageArray" + i).value = languageArrayAddValue;
				// languageVerArray(追加した言語バージョン)のvalue取得
				let languageVerArrayAddValue = sessionStorage.getItem("languageVerArrayAddValue" + i);
				document.querySelector("#languageVerArray" + i).value = languageVerArrayAddValue;
				// セッション削除
				sessionStorage.removeItem("languageArrayAddValue" + i);
				sessionStorage.removeItem("languageVerArrayAddValue" + i);
			}
		// 入力フォームを削除している場合
		} else {
			for (let i = 1; i <= parseInt(languageArrayNum) + parseInt(languageDelete); i++) {
				// languageArray(追加した言語)のvalue取得
				let languageArrayAddValue = sessionStorage.getItem("languageArrayAddValue" + i);
				if (languageArrayAddValue != null) {
					document.querySelector("#languageArray" + languageId).value = languageArrayAddValue;
					languageId++;
				}
				// languageVerArray(追加した言語バージョン)のvalue取得
				let languageVerArrayAddValue = sessionStorage.getItem("languageVerArrayAddValue" + i);
				if (languageVerArrayAddValue != null) {
					document.querySelector("#languageVerArray" + languageVerId).value = languageVerArrayAddValue;
					languageVerId++;
				}
				// セッション削除
				sessionStorage.removeItem("languageArrayAddValue" + i);
				sessionStorage.removeItem("languageVerArrayAddValue" + i);
			}
		}
	}

	// セッション削除
	sessionStorage.removeItem("languageArrayValue");
	sessionStorage.removeItem("languageVerArrayValue")
	sessionStorage.removeItem("languageDelete");


	// その他追加入力フォームを再構築
	// その他の追加の入力フォームの数
	let otherArrayNum = sessionStorage.getItem("otherArrayNum");
	// その他入力(デフォルト入力フォーム)の情報取得
	let otherArrayValue = sessionStorage.getItem("otherArrayValue");
	// その他入力バージョン(デフォルト入力フォーム)の情報取得
	let otherVerArrayValue = sessionStorage.getItem("otherVerArrayValue");
	// その他入力フォームの削除回数
	let otherDelete = sessionStorage.getItem("otherDelete");
	// 追加その他入力フォームのId
	let otherId = 1;
	// 追加その他バージョン入力フォームのId
	let otherVerId = 1;
	// 入力フォーム再構築
	// 入力フォームを追加しているかチェック
	if (otherArrayNum != null) {
		for (let i = 1; i <= otherArrayNum; i++) {
			//idが「add_other」の要素を取得
			let add_other = document.querySelector("#add_other");
			 //idが「box_other」の要素を取得
			let box_other = document.querySelector("#box_other");
			//「box_other」の要素を複製（コピー）
			let clone = box_other.cloneNode(true);
			// cloneしたHTMLのidのotherArrayにメソッドが呼ばれるプラス1ずつ足していく
			$(clone).find("#otherArray").attr("id", "otherArray" + i);
			// cloneしたHTMLのidのotherVerArrayにメソッドが呼ばれるプラス1ずつ足していく
			$(clone).find("#otherVerArray").attr("id", "otherVerArray" + i);
			//複製した要素を追加
			$(add_other).parent().append(clone);
			$(add_other).parent().append(
				'<input type="button" class="del delrelative" id="other" >'
			);
		}
		// otherArray(デフォルトの言語)のvalueを書き換え
		document.querySelector("#otherArray").defaultValue = otherArrayValue;
		// otherVerArray(デフォルトの言語バージョン)のvalueを書き換え
		document.querySelector("#otherVerArray").defaultValue = otherVerArrayValue;
		// 追加した入力フォームのvalueを再セット
		// 入力フォームを削除していない場合
		if (otherDelete == null) {
			for (let i = 1; i <= otherArrayNum; i++) {
				// otherArray(追加したその他)のvalue取得
				let otherArrayAddValue = sessionStorage.getItem("otherArrayAddValue" + i);
				document.querySelector("#otherArray" + i).value = otherArrayAddValue;
				// otherVerArray(追加したその他バージョン)のvalue取得
				let otherVerArrayAddValue = sessionStorage.getItem("otherVerArrayAddValue" + i);
				document.querySelector("#otherVerArray" + i).value = otherVerArrayAddValue;
				// セッション削除
				sessionStorage.removeItem("otherArrayAddValue" + i);
				sessionStorage.removeItem("otherVerArrayAddValue" + i);
			}
		// 入力フォームを削除している場合
		} else {
			for (let i = 1; i <= parseInt(otherArrayNum) + parseInt(otherDelete); i++) {
				// otherArray(追加したその他)のvalue取得
				let otherArrayAddValue = sessionStorage.getItem("otherArrayAddValue" + i);
				if (otherArrayAddValue != null) {
					document.querySelector("#otherArray" + otherId).value = otherArrayAddValue;
					otherId++;
				}
				// otherVerArray(追加したその他バージョン)のvalue取得
				let otherVerArrayAddValue = sessionStorage.getItem("otherVerArrayAddValue" + i);
				if (otherVerArrayAddValue != null) {
					document.querySelector("#otherVerArray" + otherVerId).value = otherVerArrayAddValue;
					otherVerId++;
				}
				// セッション削除
				sessionStorage.removeItem("otherArrayAddValue" + i);
				sessionStorage.removeItem("otherVerArrayAddValue" + i);
			}
		}
	}
	// セッション削除
	sessionStorage.removeItem("otherArrayValue");
	sessionStorage.removeItem("otherVerArrayValue");
	sessionStorage.removeItem("otherDelete");
});