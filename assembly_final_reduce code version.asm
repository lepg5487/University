TITLE	25�C80��
;--------------------------------------------------------------------------------------------------------------------------------------------------------------
Start		MACRO		
			ASSUME	SS:STACK,DS:DATASEG,CS:CODESEG,ES:CODESEG
			MOV		AX,DATASEG		
			MOV		DS,AX
			MOV		ES,AX
ENDM
;--------------------------------------------------------------------------------------------------------------------------------------------------------------
Clear		MACRO
			MOV     AX,0600H        ;�ù��V�W����
			MOV     BH,07H			;�ݩʶ¥�
			MOV     CX,0000H		;���W��
			MOV     DX,184FH		;�k�U��
			INT     10H
ENDM
;--------------------------------------------------------------------------------------------------------------------------------------------------------------
Setxy		MACRO	X,Y
			MOV		AH,02H			;�]�w��Ц�m
			MOV		BH,00
			MOV		DH,Y			;�C
			MOV		DL,X			;��
			INT		10H
ENDM
;--------------------------------------------------------------------------------------------------------------------------------------------------------------
Show		MACRO	Msg
			LEA		DX,Msg			;��ܰT��
			MOV		AH,09H			;��ܦb $ �Ÿ��H�e���r��
			INT		21H	
ENDM
;--------------------------------------------------------------------------------------------------------------------------------------------------------------
Input		MACRO
			MOV		AH,00H			;���ݿ�J AH=scan code, AL=ASCII
			INT		16H
ENDM
;--------------------------------------------------------------------------------------------------------------------------------------------------------------		
Exit		MACRO
			MOV     AX,4C00H		;�����{��
			INT		21H
ENDM
;--------------------------------------------------------------------------------------------------------------------------------------------------------------
HChar		MACRO	Char
			MOV     AH,09H			
			MOV		AL,Char
			MOV		BX,0070H		;�ϥ�
			MOV		CX,01
			INT		10H
ENDM
;--------------------------------------------------------------------------------------------------------------------------------------------------------------
LChar		MACRO	Count
			MOV     AH,09H			
			MOV		AL,' '
			MOV		BX,0007H		;�϶�
			MOV		CX,Count
			INT		10H
ENDM
;--------------------------------------------------------------------------------------------------------------------------------------------------------------
Savexy		MACRO	X,Y
			MOV		DL,X		;�s�y��
			MOV		DH,Y
			MOV		[DI],DL		;�s�y��
			MOV		[SI],DH
ENDM
;--------------------------------------------------------------------------------------------------------------------------------------------------------------
PrintDL		MACRO
			MOV		AH,02H			;�|�NDL�Ȧs�������e�L��ù��W
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
		Savex	DB	02				;�ثe��� X �y��
		Savey	DB	00				;�ثe��� Y �y��

DATASEG ENDS
;--------------------------------------------------------------------------------------------------------------------------------------------------------------
CODESEG SEGMENT PARA 'Code'
Main	PROC	FAR		
		LEA		SI,Savey
		LEA		DI,Savex					
		Start					;�Ȧs����l��
		Clear					;�M���ù�	
		Setxy	00,00			;��ܥ\��C
		Show	Msg2
		Setxy	00,01			;��ܤW���j�u
		Show	Msg1
		Setxy	00,23			;��ܤU���j�u
		Show	Msg1
		Setxy	43,24			;��ܪ��A�C
		Show	Msg3
		Setxy	00,02			;�]�w��l��Ц�m

A10:	
		Input					;��J

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
		CMP		AH,48H		;AH = scan code = 4DH, �W
		JE		Up
		CMP		AH,50H		;AH = scan code = 4DH, �U
		JE		Down
		CMP		AH,4BH		;AH = scan code = 4DH, ��
		JE		Left
		CMP		AH,4DH		;AH = scan code = 4DH, �k
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
		MOV		[DI],DH				;�s�y��
		MOV		[SI],DL
		Setxy	[SI],[DI]
		JMP		A10
Down:
		CMP		DH,00H
		JE		Stop
		CMP		DH,22
		JE		Stop
		INC		DH
		MOV		[DI],DH				;�s�y��
		MOV		[SI],DL
		Setxy	[SI],[DI]
		JMP		A10
Left:
		CMP		DH,00H
		JE		LeftEsc
		CMP		DL,00H
		JE		Stop
		DEC		DL
		MOV		[DI],DH				;�s�y��
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
		MOV		[DI],DH				;�s�y��
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
Stop:								;�W�U���k����W�L����
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
		Setxy	43,24				;�ϥ�Insert
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
		Setxy	00,00			;Copy   ���ܥ�
		HChar	43H
		Setxy	01,00
		HChar	6FH
		Setxy	02,00
		HChar	70H
		Setxy	03,00
		HChar	79H
		JMP		A10
EscCode1:
		Setxy	00,00			;Copy  ���ܶ�
		LChar	04				
		Setxy	00,00			
		Show	Msg2

		Setxy	8,00			;Cut   ���ܥ�
		HChar	43H
		Setxy	9,00
		HChar	75H
		Setxy	10,00
		HChar	74H
		JMP		A10
EscCode2:
		Setxy	08,00			;Cut ���ܶ�
		LChar	03				
		Setxy	00,00
		Show	Msg2

		Setxy	15,00			;Paste ���ܥ�
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
		Setxy	15,00			;Paste ���ܶ�
		LChar	05				
		Setxy	00,00
		Show	Msg2
	
		Setxy	24,00			;Exit  ���ܥ�
		HChar	45H
		Setxy	25,00
		HChar	78H
		Setxy	26,00
		HChar	69H
		Setxy	27,00
		HChar	74H
		Input					;��J
		CMP		AH,1CH			;AH = scan code = 1CH, Enter
		JE		EnterCode
		JMP		A10
EscCode4:
		Setxy	24,00			;Exit  ���ܶ�
		LChar	04				
		Setxy	00,00			
		Show	Msg2

		Setxy	15,00			;Paste ���ܥ�
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
		Setxy	15,00			;Paste ���ܶ�
		LChar	05				
		Setxy	00,00
		Show	Msg2

		Setxy	8,00			;Cut   ���ܥ�
		HChar	43H
		Setxy	9,00
		HChar	75H
		Setxy	10,00
		HChar	74H
		JMP		A10
EscCode6:
		Setxy	08,00			;Cut ���ܶ�
		LChar	03				
		Setxy	00,00
		Show	Msg2

		Setxy	00,00			;Copy   ���ܥ�
		HChar	43H
		Setxy	01,00
		HChar	6FH
		Setxy	02,00
		HChar	70H
		Setxy	03,00
		HChar	79H
		JMP		A10
EscCodeBack:
		Setxy	00,00			;���G��ESC �Ĥ@�C�����M�Ť϶�
		LChar	30
		Show	Msg2			;���G��ESC ���s��X�\��C
		Setxy	[SI],[DI]
		JMP		A10

BackSpace:
		CMP		DH,00H
		JE		Stop
		CMP		DL,00H
		JE		Stop
		DEC		DL
		MOV		[DI],DH			;�s�y��
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
		MOV		DL,00H		;�y�г]��̥���
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
		CMP		DL,4FH		;�O�_��̥k��F
		JE		Printdown	;��̥k��ɮy�в���U�@�C���̥���
		JNE		Print		;�S����̥k��ɪ�����y��+1 �M �L�X��J
		
Print:	
		INC		DL			;�y�Щ��k
		MOV		[DI],DH
		MOV		[SI],DL
		PrintDL				;�|�NDL�Ȧs�������e�L��ù��W
		MOV		DL,[SI]
		JMP		A10

Printdown:
		INC		DH			;�y�Щ��U
		MOV		DL,00H		;�y�г]��̥���
		MOV		[DI],DH
		MOV		[SI],DL

		PrintDL				;�|�NDL�Ȧs�������e�L��ù��W
		MOV		DL,[SI]
		JMP		A10

Main	ENDP
CODESEG ENDS
		END		Main