/*
生年月日の入力された時に
年齢を自動計算するイベント
*/
const selectElement = document.querySelector('.date-input');//生年月日入力欄のエレメントを変数に代入

/*
生年月日入力欄が変更された時
入力された値を年齢に変換しidがageのテキストに表示するメソッド
*/
selectElement.addEventListener('change', function() {
    var dateInput = document.getElementById( "date" ).value ; //生年月日の値を取得
    var birthday = dateInput.replace(/-/g, '');//例)1990-10-06を19901006に変換する
    document.getElementById("age").innerText = getAge( birthday );//getAgeメソッドで得た値をテキストに表示
});

//年齢を計算するメソッド
function getAge( birthday ){
    var today = new Date(); //Dateオブジェクトを生成
    //現在の日付を取得
    var tdate = ( today.getFullYear() * 10000 ) + (( today.getMonth() + 1 ) * 100 ) + today.getDate();
    return( Math.floor(( tdate - birthday ) / 10000 ));//年齢を計算して返す
}
