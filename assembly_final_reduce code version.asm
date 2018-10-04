TITLE	25列80行
;--------------------------------------------------------------------------------------------------------------------------------------------------------------
Start		MACRO		
			ASSUME	SS:STACK,DS:DATASEG,CS:CODESEG,ES:CODESEG
			MOV		AX,DATASEG		
			MOV		DS,AX
			MOV		ES,AX
ENDM
;--------------------------------------------------------------------------------------------------------------------------------------------------------------
Clear		MACRO
			MOV     AX,0600H        ;螢幕向上捲動
			MOV     BH,07H			;屬性黑白
			MOV     CX,0000H		;左上角
			MOV     DX,184FH		;右下角
			INT     10H
ENDM
;--------------------------------------------------------------------------------------------------------------------------------------------------------------
Setxy		MACRO	X,Y
			MOV		AH,02H			;設定游標位置
			MOV		BH,00
			MOV		DH,Y			;列
			MOV		DL,X			;行
			INT		10H
ENDM
;--------------------------------------------------------------------------------------------------------------------------------------------------------------
Show		MACRO	Msg
			LEA		DX,Msg			;顯示訊息
			MOV		AH,09H			;顯示在 $ 符號以前的字串
			INT		21H	
ENDM
;--------------------------------------------------------------------------------------------------------------------------------------------------------------
Input		MACRO
			MOV		AH,00H			;等待輸入 AH=scan code, AL=ASCII
			INT		16H
ENDM
;--------------------------------------------------------------------------------------------------------------------------------------------------------------		
Exit		MACRO
			MOV     AX,4C00H		;結束程式
			INT		21H
ENDM
;--------------------------------------------------------------------------------------------------------------------------------------------------------------
HChar		MACRO	Char
			MOV     AH,09H			
			MOV		AL,Char
			MOV		BX,0070H		;反白
			MOV		CX,01
			INT		10H
ENDM
;--------------------------------------------------------------------------------------------------------------------------------------------------------------
LChar		MACRO	Count
			MOV     AH,09H			
			MOV		AL,' '
			MOV		BX,0007H		;反黑
			MOV		CX,Count
			INT		10H
ENDM
;--------------------------------------------------------------------------------------------------------------------------------------------------------------
Savexy		MACRO	X,Y
			MOV		DL,X		;存座標
			MOV		DH,Y
			MOV		[DI],DL		;存座標
			MOV		[SI],DH
ENDM
;--------------------------------------------------------------------------------------------------------------------------------------------------------------
PrintDL		MACRO
			MOV		AH,02H			;會將DL暫存器的內容印到螢幕上
			MOV		DL,AL
			INT		21H
ENDM
;--------------------------------------------------------------------------------------------------------------------------------------------------------------

;--------------------------------------------------------------------------------------------------------------------------------------------------------------


STACK	SEGMENT PARA STACK 'Stack'
		DB		64	DUP(0)
STACK	ENDS
;--------------------------------------------------------------------------------------------------------------------------------------------------------------
DATASEG SEGMENT	PARA 'Data'
		Msg1	DB	'--------------------------------------------------------------------------------','$'
		Msg2	DB	'Copy    Cut    Paste    Exit','$'
		Msg3	DB	'Insert    NumLock    Caps    Row,Col','$'
		Msg4	DB	'Insert','$'
		Msg5	DB	'NumLock','$'
		Msg6	DB	'Caps','$' 
		Savex	DB	02				;目前游標 X 座標
		Savey	DB	00				;目前游標 Y 座標

DATASEG ENDS
;--------------------------------------------------------------------------------------------------------------------------------------------------------------
CODESEG SEGMENT PARA 'Code'
Main	PROC	FAR		
		LEA		SI,Savey
		LEA		DI,Savex					
		Start					;暫存器初始化
		Clear					;清除螢幕	
		Setxy	00,00			;顯示功能列
		Show	Msg2
		Setxy	00,01			;顯示上分隔線
		Show	Msg1
		Setxy	00,23			;顯示下分隔線
		Show	Msg1
		Setxy	43,24			;顯示狀態列
		Show	Msg3
		Setxy	00,02			;設定初始游標位置

A10:	
		Input					;輸入

		CMP     AH,1EH          ;a	
        JE      Printcom								
        CMP     AH,30H          ;b
        JE      Printcom   
		CMP     AH,2EH          ;c
        JE      Printcom   
		CMP     AH,20H          ;d	
        JE      Printcom
		CMP     AH,12H          ;e
        JE      Printcom
		CMP     AH,21H          ;f
        JE      Printcom
		CMP     AH,22H          ;g
        JE      Printcom
		CMP     AH,23H          ;h
        JE      Printcom
		CMP     AH,17H          ;i
        JE      Printcom
		CMP     AH,24H          ;j
        JE      Printcom
		CMP     AH,25H          ;k
        JE      Printcom
		CMP     AH,26H          ;l
        JE      Printcom
		CMP     AH,32H          ;m
        JE      Printcom
		CMP     AH,31H          ;n
        JE      Printcom
		CMP     AH,18H          ;o
        JE      Printcom
		CMP     AH,19H          ;p
        JE      Printcom
		CMP     AH,10H          ;q
        JE      Printcom
		CMP     AH,13H          ;r
        JE      Printcom
		CMP     AH,1FH          ;s
        JE      Printcom
		CMP     AH,14H          ;t
        JE      Printcom
		CMP     AH,16H          ;u
        JE      Printcom
		CMP     AH,2FH          ;v
        JE      Printcom
		CMP     AH,11H          ;w
        JE      Printcom
		CMP     AH,2DH          ;x
        JE      Printcom
		CMP     AH,15H          ;y
        JE      Printcom
		CMP     AH,2CH          ;z
        JE      Printcom
;-------------------------------------------------------------------------------------
		CMP		AH,48H		;AH = scan code = 4DH, 上
		JE		Up
		CMP		AH,50H		;AH = scan code = 4DH, 下
		JE		Down
		CMP		AH,4BH		;AH = scan code = 4DH, 左
		JE		Left
		CMP		AH,4DH		;AH = scan code = 4DH, 右
		JE		Right
		CMP		AH,47H		;AH = scan code = 4DH, Home
		JE		Home
		CMP		AH,4FH		;AH = scan code = 4DH, End
		JE		EndCode
		CMP		AH,49H		;AH = scan code = 4DH, PageUp
		JE		PageUp
		CMP		AH,51H		;AH = scan code = 4DH, PageDown
		JE		PageDown
		CMP		AH,52H		;AH = scan code = 4DH, Insert
		JE		Insert
		CMP		AH,53H		;AH = scan code = 4DH, Delete
		JE		Delete
		CMP		AH,3A		;AH = scan code = 4DH, Caps
		JE		Caps
		CMP		AH,45		;AH = scan code = 4DH, NumLock
		JE		NumLock
		CMP		AH,01H		;AH = scan code = 4DH, Esc
		JE		EscCode
		CMP		AH,0EH		;AH = scan code = 0EH, BackSpace
		JE		BackSpace
		CMP		AH,1CH		;AH = scan code = 1CH, Enter
		JE		EnterCode1
		JMP		A10
	
Up:	
		CMP		DH,02H
		JE		Stop
		DEC		DH
		MOV		[DI],DH				;存座標
		MOV		[SI],DL
		Setxy	[SI],[DI]
		JMP		A10
Down:
		CMP		DH,00H
		JE		Stop
		CMP		DH,22
		JE		Stop
		INC		DH
		MOV		[DI],DH				;存座標
		MOV		[SI],DL
		Setxy	[SI],[DI]
		JMP		A10
Left:
		CMP		DH,00H
		JE		LeftEsc
		CMP		DL,00H
		JE		Stop
		DEC		DL
		MOV		[DI],DH				;存座標
		MOV		[SI],DL
		Setxy	[SI],[DI]
		JMP		A10
LeftEsc:
		CMP		DL,27
		JE		EscCode4
		CMP		DL,19
		JE		EscCode5	
		CMP		DL,10
		JE		EscCode6

		JMP		A10
Right:	
		CMP		DH,00H
		JE		RightEsc
		CMP		DL,4FH
		JE		Stop
		INC		DL
		MOV		[DI],DH				;存座標
		MOV		[SI],DL
		Setxy	[SI],[DI]
		JMP		A10
RightEsc:	
		CMP		DL,03
		JE		EscCode1
		CMP		DL,10
		JE		EscCode2
		CMP		DL,19
		JE		EscCode3
		JMP		A10
Stop:								;上下左右不能超過視窗
		JMP		A10

Home:	
		CMP		DH,00H
		JE		Stop
		Setxy	00,[DI]
		JMP		A10
EndCode:
		CMP		DH,00H
		JE		Stop
		Setxy	79,[DI]
		JMP		A10
PageUp:
	
PageDown:
	
Insert:		
		CMP		BL,70H
		JE		InsertBack
		Setxy	43,24				;反白Insert
		HChar	49H
		Setxy	44,24
		HChar	6EH
		Setxy	45,24
		HChar	73H
		Setxy	46,24
		HChar	65H
		Setxy	47,24
		HChar	72H
		Setxy	48,24
		HChar	74H
		Setxy	[SI],[DI]
		JMP		A10

InsertBack:	
		Setxy	43,24
		LChar	06
		Setxy	43,24
		Show	Msg4
		Setxy	[SI],[DI]
		JMP		A10


Delete:

		JMP		A10
NumLock:

		JMP		A10
NumLockBack:
		
		JMP		A10
reNumLockBack:

		JMP		A10
EscCode:
		CMP		DH,00H
		JE		EscCodeBack
		Setxy	00,00			;Copy   黑變白
		HChar	43H
		Setxy	01,00
		HChar	6FH
		Setxy	02,00
		HChar	70H
		Setxy	03,00
		HChar	79H
		JMP		A10
EscCode1:
		Setxy	00,00			;Copy  白變黑
		LChar	04				
		Setxy	00,00			
		Show	Msg2

		Setxy	8,00			;Cut   黑變白
		HChar	43H
		Setxy	9,00
		HChar	75H
		Setxy	10,00
		HChar	74H
		JMP		A10
EscCode2:
		Setxy	08,00			;Cut 白變黑
		LChar	03				
		Setxy	00,00
		Show	Msg2

		Setxy	15,00			;Paste 黑變白
		HChar	50H
		Setxy	16,00
		HChar	61H
		Setxy	17,00
		HChar	73H
		Setxy	18,00
		HChar	74H
		Setxy	19,00
		HChar	65H
		JMP		A10
EscCode3:
		Setxy	15,00			;Paste 白變黑
		LChar	05				
		Setxy	00,00
		Show	Msg2
	
		Setxy	24,00			;Exit  黑變白
		HChar	45H
		Setxy	25,00
		HChar	78H
		Setxy	26,00
		HChar	69H
		Setxy	27,00
		HChar	74H
		Input					;輸入
		CMP		AH,1CH			;AH = scan code = 1CH, Enter
		JE		EnterCode
		JMP		A10
EscCode4:
		Setxy	24,00			;Exit  白變黑
		LChar	04				
		Setxy	00,00			
		Show	Msg2

		Setxy	15,00			;Paste 黑變白
		HChar	50H
		Setxy	16,00
		HChar	61H
		Setxy	17,00
		HChar	73H
		Setxy	18,00
		HChar	74H
		Setxy	19,00
		HChar	65H
		JMP		A10
EscCode5:
		Setxy	15,00			;Paste 白變黑
		LChar	05				
		Setxy	00,00
		Show	Msg2

		Setxy	8,00			;Cut   黑變白
		HChar	43H
		Setxy	9,00
		HChar	75H
		Setxy	10,00
		HChar	74H
		JMP		A10
EscCode6:
		Setxy	08,00			;Cut 白變黑
		LChar	03				
		Setxy	00,00
		Show	Msg2

		Setxy	00,00			;Copy   黑變白
		HChar	43H
		Setxy	01,00
		HChar	6FH
		Setxy	02,00
		HChar	70H
		Setxy	03,00
		HChar	79H
		JMP		A10
EscCodeBack:
		Setxy	00,00			;按二次ESC 第一列全部清空反黑
		LChar	30
		Show	Msg2			;按二次ESC 重新輸出功能列
		Setxy	[SI],[DI]
		JMP		A10

BackSpace:
		CMP		DH,00H
		JE		Stop
		CMP		DL,00H
		JE		Stop
		DEC		DL
		MOV		[DI],DH			;存座標
		MOV		[SI],DL
		Setxy	[SI],[DI]
		LChar	01
		JMP		A10

Caps:		
		
		JMP		A10
CapsBack:	
		
		JMP		A10
EnterCode1:
		CMP		DH,00
		JE		Stop
		INC		DH
		MOV		DL,00H		;座標設到最左邊
		MOV		[DI],DH
		MOV		[SI],DL
		Setxy	[SI],[DI]
		JMP		A10
EnterCode:
		Clear
		Exit
		JMP		A10

Printcom:	
		CMP		DH,00H
		JE		Stop
		CMP		DL,4FH		;是否到最右邊了
		JE		Printdown	;到最右邊時座標移到下一列的最左邊
		JNE		Print		;沒有到最右邊時直接行座標+1 和 印出輸入
		
Print:	
		INC		DL			;座標往右
		MOV		[DI],DH
		MOV		[SI],DL
		PrintDL				;會將DL暫存器的內容印到螢幕上
		MOV		DL,[SI]
		JMP		A10

Printdown:
		INC		DH			;座標往下
		MOV		DL,00H		;座標設到最左邊
		MOV		[DI],DH
		MOV		[SI],DL

		PrintDL				;會將DL暫存器的內容印到螢幕上
		MOV		DL,[SI]
		JMP		A10

Main	ENDP
CODESEG ENDS
		END		Main