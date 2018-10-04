TITLE	25�C80��
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
		CALL	Start		;�Ȧs����l��
		CALL	Clean		;�M���ù�	
		CALL	Show		;��ܥ\��C
		CALL	Printpart1	;��ܤW���j�u
		CALL	Printpart2	;��ܤU���j�u
		CALL	Show1		;��ܪ��A�C
		CALL	Setstart	;�]�w��l��Ц�m

	;	MOV		AL,12H			;Caps ���S����
	;	INT		16H
	;	AND		AH,01000000B
	;	JZ		Caps

	;	MOV		AL,12H			;NumLock ���S����
	;	INT		16H
	;	AND		AH,00100000B
	;	JZ		NumLock


A10:	

		CALL	Input		;��J
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
;----------------------------------------------------------------
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
		CMP		AH,1CH			;AH = scan code = 1CH, Enter
		JE		EnterCode1
		JMP		A10
	
Up:	
		CMP		DH,02H
		JE		Stop
		DEC		DH
		MOV		[DI],DH		;�s�y��
		MOV		[SI],DL
		CALL	Setnext
		JMP		A10
Down:
		CMP		DH,00H
		JE		Stop
		CMP		DH,22
		JE		Stop
		INC		DH
		MOV		[DI],DH		;�s�y��
		MOV		[SI],DL
		CALL	Setnext
		JMP		A10
Left:
		CMP		DH,00H
		JE		LeftEsc
		CMP		DL,00H
		JE		Stop
		DEC		DL
		MOV		[DI],DH		;�s�y��
		MOV		[SI],DL
		CALL	Setnext
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
		MOV		[DI],DH		;�s�y��
		MOV		[SI],DL
		CALL	Setnext
		JMP		A10
RightEsc:	
		CMP		DL,03
		JE		EscCode1
		CMP		DL,10
		JE		EscCode2
		CMP		DL,19
		JE		EscCode3

		JMP		A10
Stop:						;�W�U���k����W�L����
		JMP		A10

Home:	
		MOV		DL,00H
		CALL	Setnext
		JMP		A10
EndCode:
		MOV		DL,4FH
		CALL	Setnext
		JMP		A10
PageUp:
	;	MOV		CX,14
	;	DEC		DH
	;	LOOP
PageDown:
	;	MOV		DH,14H
Insert:	
		CMP		BL,70H
		JE		InsertBack
		CALL	HighLight7
		CALL	Setstart
		JMP		A10

InsertBack:
		CALL	show2
		CALL	Setstart
		JMP		A10
Delete:

		JMP		A10
NumLock:
		CMP		BL,70H
		JE		NumLockBack
		CALL	HighLight8
		CALL	Setstart
		JMP		A10
NumLockBack:
		MOV		AH,12H			;NumLock ���S����
		INT		16H
		AND		AL,00100000B
		JZ		reNumLockBack
		JMP		A10
reNumLockBack:
		CALL	reHighLight8
		CALL	show3
		CALL	Setstart

		JMP		A10

EscCode:
		CMP		DH,00H
		JE		EscCodeBack
		CALL	Show
		CALL	HighLight
		JMP		A10
EscCode1:
		CALL	HighLight1
		JMP		A10
EscCode2:
		CALL	HighLight2
		JMP		A10
EscCode3:
		CALL	HighLight3
		CALL	Input			;��J
		CMP		AH,1CH			;AH = scan code = 1CH, Enter
		JE		EnterCode
		JMP		A10
EscCode4:
		CALL	HighLight4
		JMP		A10
EscCode5:
		CALL	HighLight5
		JMP		A10
EscCode6:
		CALL	HighLight6
		JMP		A10
EscCodeBack:
		CALL	ReHighLight
		CALL	show	
		CALL	Setstart
		JMP		A10

BackSpace:
		CMP		DL,00H
		JE		Stop
		DEC		DL
		MOV		[DI],DH			;�s�y��
		MOV		[SI],DL
		CALL	HighLight10
		JMP		A10

Caps:		
		CMP		BL,70H
		JE		CapsBack
		CALL	HighLight9
		CALL	Setstart
		JMP		A10
CapsBack:	
		CALL	show4
		CALL	Setstart
		JMP		A10
EnterCode1:
		CMP		DH,00
		JE		Stop
		INC		DH
		MOV		DL,00H		;�y�г]��̥���
		MOV		[DI],DH
		MOV		[SI],DL
		CALL	Setstart
		JMP		A10
EnterCode:
		CALL	Clean
		CALL	Exit
		JMP		A10
;-------------------------------------------------------------------------
Printcom:	
		;CMP		DH,17H	;�O�_��̤U���̥k��
		;JE		Last
		CMP		DL,4FH		;�O�_��̥k��F
		JE		Printdown	;��̥k��ɮy�в���U�@�C���̥���
		JNE		Print		;�S����̥k��ɪ�����y��+1 �M �L�X��J
		
Print:	
		INC		DL			;�y�Щ��k
		MOV		[DI],DH
		MOV		[SI],DL
		CALL	PrintDL		;�L�X��J���F��
		MOV		DL,[SI]
		JMP		A10

Printdown:
		INC		DH			;�y�Щ��U
		MOV		DL,00H		;�y�г]��̥���
		MOV		[DI],DH
		MOV		[SI],DL
		CALL	PrintDL		;�L�X��J���F��
		MOV		DL,[SI]
		JMP		A10

Last:
		;CALL	Cleanfirst
		CALL	Show		;��ܥ\��C
		CALL	Printpart1	;��ܤW���j�u
		;CALL	Setlast
		JMP		A10

;		CALL	Exit		;�����{��

Main	ENDP
;--------------------------------------------------------------------------------------------------------------------------------------------------------------
Setnext		PROC	FAR	
			MOV		AH,02H		;�]�w��Ц�m
			MOV		BH,00
			INT		10H
			RET
Setnext		ENDP
;--------------------------------------------------------------------------------------------------------------------------------------------------------------
Setlast		PROC	FAR	
			MOV		AH,02H		;�]�w��Ц�m
			MOV		BH,00
			MOV		DH,22		;�C
			MOV		DL,00		;��
			INT		10H
			RET
Setlast		ENDP
;--------------------------------------------------------------------------------------------------------------------------------------------------------------
Cleanfirst	PROC	FAR	
			MOV     AX,0600H        ;�ù��V�W����
		    MOV     BH,07H			;�ݩʶ¥�
			MOV     CX,0000H		;���W��
			MOV     DX,024FH		;�Ĥ@�C�M��
			INT     10H
			RET
Cleanfirst	ENDP
;--------------------------------------------------------------------------------------------------------------------------------------------------------------
Setstart	PROC	FAR	
			MOV		AH,02H		;�]�w��Ц�m
			MOV		BH,00
			MOV		DH,[DI]		;�C
			MOV		DL,[SI]		;��
			INT		10H
			RET
Setstart	ENDP
;--------------------------------------------------------------------------------------------------------------------------------------------------------------
Input		PROC	FAR	
			MOV		AH,00H		;���ݿ�JAH=scan code,AL=ASCII
			INT		16H
			RET
Input		ENDP
;--------------------------------------------------------------------------------------------------------------------------------------------------------------
HighLight	PROC	FAR
			MOV		AH,02H		;�]�w��Ц�m
			MOV		BH,00
			MOV		DH,00		;�C
			MOV		DL,00		;��
			INT		10H
			MOV     AH,09H		;C�ϥ�
			MOV		AL,'C'
			MOV		BX,0070H
			MOV		CX,01
			INT		10H

			MOV		AH,02H		;�]�w��Ц�m
			MOV		BH,00
			MOV		DH,00		;�C
			MOV		DL,01		;��
			INT		10H
			MOV     AH,09H 
			MOV		AL,'o'		;o�ϥ�
			MOV		BX,0070H
			MOV		CX,01
			INT		10H

			MOV		AH,02H		;�]�w��Ц�m
			MOV		BH,00
			MOV		DH,00		;�C
			MOV		DL,02		;��
			INT		10H
			MOV     AH,09H 
			MOV		AL,'p'		;p�ϥ�
			MOV		BX,0070H
			MOV		CX,01
			INT		10H

			MOV		AH,02H		;�]�w��Ц�m
			MOV		BH,00
			MOV		DH,00		;�C
			MOV		DL,03		;��
			INT		10H
			MOV     AH,09H 
			MOV		AL,'y'		;y�ϥ�
			MOV		BX,0070H
			MOV		CX,01
			INT		10H
			RET
HighLight	ENDP
;--------------------------------------------------------------------------------------------------------------------------------------------------------------
HighLight1	PROC	FAR
			MOV		AH,02H		;�]�w��Ц�m
			MOV		BH,00
			MOV		DH,00		;�C
			MOV		DL,00		;��
			INT		10H
			MOV     AH,09H		;C�ϥ�
			MOV		AL,'C'
			MOV		BX,0007H
			MOV		CX,01
			INT		10H

			MOV		AH,02H		;�]�w��Ц�m
			MOV		BH,00
			MOV		DH,00		;�C
			MOV		DL,01		;��
			INT		10H
			MOV     AH,09H 
			MOV		AL,'o'		;o�ϥ�
			MOV		BX,0007H
			MOV		CX,01
			INT		10H

			MOV		AH,02H		;�]�w��Ц�m
			MOV		BH,00
			MOV		DH,00		;�C
			MOV		DL,02		;��
			INT		10H
			MOV     AH,09H 
			MOV		AL,'p'		;p�ϥ�
			MOV		BX,0007H
			MOV		CX,01
			INT		10H

			MOV		AH,02H		;�]�w��Ц�m
			MOV		BH,00
			MOV		DH,00		;�C
			MOV		DL,03		;��
			INT		10H
			MOV     AH,09H 
			MOV		AL,'y'		;y�ϥ�
			MOV		BX,0007H
			MOV		CX,01
			INT		10H
;---------
			MOV		AH,02H		;�]�w��Ц�m
			MOV		BH,00
			MOV		DH,00		;�C
			MOV		DL,08		;��
			INT		10H
			MOV     AH,09H		;C�ϥ�
			MOV		AL,'C'
			MOV		BX,0070H
			MOV		CX,01
			INT		10H

			MOV		AH,02H		;�]�w��Ц�m
			MOV		BH,00
			MOV		DH,00		;�C
			MOV		DL,09		;��
			INT		10H
			MOV     AH,09H 
			MOV		AL,'u'		;u�ϥ�
			MOV		BX,0070H
			MOV		CX,01
			INT		10H

			MOV		AH,02H		;�]�w��Ц�m
			MOV		BH,00
			MOV		DH,00		;�C
			MOV		DL,10		;��
			INT		10H
			MOV     AH,09H 
			MOV		AL,'t'		;p�ϥ�
			MOV		BX,0070H
			MOV		CX,01
			INT		10H
			RET
HighLight1	ENDP
;--------------------------------------------------------------------------------------------------------------------------------------------------------------
HighLight2	PROC	FAR
			MOV		AH,02H		;�]�w��Ц�m
			MOV		BH,00
			MOV		DH,00		;�C
			MOV		DL,08		;��
			INT		10H
			MOV     AH,09H		;C�ϥ�
			MOV		AL,'C'
			MOV		BX,0007H
			MOV		CX,01
			INT		10H

			MOV		AH,02H		;�]�w��Ц�m
			MOV		BH,00
			MOV		DH,00		;�C
			MOV		DL,09		;��
			INT		10H
			MOV     AH,09H 
			MOV		AL,'u'		;u�ϥ�
			MOV		BX,0007H
			MOV		CX,01
			INT		10H

			MOV		AH,02H		;�]�w��Ц�m
			MOV		BH,00
			MOV		DH,00		;�C
			MOV		DL,10		;��
			INT		10H
			MOV     AH,09H 
			MOV		AL,'t'		;p�ϥ�
			MOV		BX,0007H
			MOV		CX,01
			INT		10H
;---------
			MOV		AH,02H		;�]�w��Ц�m
			MOV		BH,00
			MOV		DH,00		;�C
			MOV		DL,15		;��
			INT		10H
			MOV     AH,09H		;C�ϥ�
			MOV		AL,'P'
			MOV		BX,0070H
			MOV		CX,01
			INT		10H

			MOV		AH,02H		;�]�w��Ц�m
			MOV		BH,00
			MOV		DH,00		;�C
			MOV		DL,16		;��
			INT		10H
			MOV     AH,09H 
			MOV		AL,'a'		;u�ϥ�
			MOV		BX,0070H
			MOV		CX,01
			INT		10H

			MOV		AH,02H		;�]�w��Ц�m
			MOV		BH,00
			MOV		DH,00		;�C
			MOV		DL,17		;��
			INT		10H
			MOV     AH,09H 
			MOV		AL,'s'		;p�ϥ�
			MOV		BX,0070H
			MOV		CX,01
			INT		10H

			MOV		AH,02H		;�]�w��Ц�m
			MOV		BH,00
			MOV		DH,00		;�C
			MOV		DL,18		;��
			INT		10H
			MOV     AH,09H 
			MOV		AL,'t'		;p�ϥ�
			MOV		BX,0070H
			MOV		CX,01
			INT		10H

			MOV		AH,02H		;�]�w��Ц�m
			MOV		BH,00
			MOV		DH,00		;�C
			MOV		DL,19		;��
			INT		10H
			MOV     AH,09H 
			MOV		AL,'e'		;p�ϥ�
			MOV		BX,0070H
			MOV		CX,01
			INT		10H

			RET
HighLight2	ENDP
;--------------------------------------------------------------------------------------------------------------------------------------------------------------
HighLight3	PROC	FAR
			MOV		AH,02H		;�]�w��Ц�m
			MOV		BH,00
			MOV		DH,00		;�C
			MOV		DL,15		;��
			INT		10H
			MOV     AH,09H		;C�ϥ�
			MOV		AL,'P'
			MOV		BX,0007H
			MOV		CX,01
			INT		10H

			MOV		AH,02H		;�]�w��Ц�m
			MOV		BH,00
			MOV		DH,00		;�C
			MOV		DL,16		;��
			INT		10H
			MOV     AH,09H 
			MOV		AL,'a'		;u�ϥ�
			MOV		BX,0007H
			MOV		CX,01
			INT		10H

			MOV		AH,02H		;�]�w��Ц�m
			MOV		BH,00
			MOV		DH,00		;�C
			MOV		DL,17		;��
			INT		10H
			MOV     AH,09H 
			MOV		AL,'s'		;p�ϥ�
			MOV		BX,0007H
			MOV		CX,01
			INT		10H

			MOV		AH,02H		;�]�w��Ц�m
			MOV		BH,00
			MOV		DH,00		;�C
			MOV		DL,18		;��
			INT		10H
			MOV     AH,09H 
			MOV		AL,'t'		;p�ϥ�
			MOV		BX,0007H
			MOV		CX,01
			INT		10H

			MOV		AH,02H		;�]�w��Ц�m
			MOV		BH,00
			MOV		DH,00		;�C
			MOV		DL,19		;��
			INT		10H
			MOV     AH,09H 
			MOV		AL,'e'		;p�ϥ�
			MOV		BX,0007H
			MOV		CX,01
			INT		10H
;----------
			MOV		AH,02H		;�]�w��Ц�m
			MOV		BH,00
			MOV		DH,00		;�C
			MOV		DL,24		;��
			INT		10H
			MOV     AH,09H		;C�ϥ�
			MOV		AL,'E'
			MOV		BX,0070H
			MOV		CX,01
			INT		10H

			MOV		AH,02H		;�]�w��Ц�m
			MOV		BH,00
			MOV		DH,00		;�C
			MOV		DL,25		;��
			INT		10H
			MOV     AH,09H 
			MOV		AL,'x'		;o�ϥ�
			MOV		BX,0070H
			MOV		CX,01
			INT		10H

			MOV		AH,02H		;�]�w��Ц�m
			MOV		BH,00
			MOV		DH,00		;�C
			MOV		DL,26		;��
			INT		10H
			MOV     AH,09H 
			MOV		AL,'i'		;p�ϥ�
			MOV		BX,0070H
			MOV		CX,01
			INT		10H

			MOV		AH,02H		;�]�w��Ц�m
			MOV		BH,00
			MOV		DH,00		;�C
			MOV		DL,27		;��
			INT		10H
			MOV     AH,09H 
			MOV		AL,'t'		;y�ϥ�
			MOV		BX,0070H
			MOV		CX,01
			INT		10H
			RET
HighLight3	ENDP

;--------------------------------------------------------------------------------------------------------------------------------------------------------------
HighLight4	PROC	FAR
			MOV		AH,02H		;�]�w��Ц�m
			MOV		BH,00
			MOV		DH,00		;�C
			MOV		DL,24		;��
			INT		10H
			MOV     AH,09H		;C�ϥ�
			MOV		AL,'E'
			MOV		BX,0007H
			MOV		CX,01
			INT		10H

			MOV		AH,02H		;�]�w��Ц�m
			MOV		BH,00
			MOV		DH,00		;�C
			MOV		DL,25		;��
			INT		10H
			MOV     AH,09H 
			MOV		AL,'x'		;o�ϥ�
			MOV		BX,0007H
			MOV		CX,01
			INT		10H

			MOV		AH,02H		;�]�w��Ц�m
			MOV		BH,00
			MOV		DH,00		;�C
			MOV		DL,26		;��
			INT		10H
			MOV     AH,09H 
			MOV		AL,'i'		;p�ϥ�
			MOV		BX,0007H
			MOV		CX,01
			INT		10H

			MOV		AH,02H		;�]�w��Ц�m
			MOV		BH,00
			MOV		DH,00		;�C
			MOV		DL,27		;��
			INT		10H
			MOV     AH,09H 
			MOV		AL,'t'		;y�ϥ�
			MOV		BX,0007H
			MOV		CX,01
			INT		10H
;---------
			MOV		AH,02H		;�]�w��Ц�m
			MOV		BH,00
			MOV		DH,00		;�C
			MOV		DL,15		;��
			INT		10H
			MOV     AH,09H		;C�ϥ�
			MOV		AL,'P'
			MOV		BX,0070H
			MOV		CX,01
			INT		10H

			MOV		AH,02H		;�]�w��Ц�m
			MOV		BH,00
			MOV		DH,00		;�C
			MOV		DL,16		;��
			INT		10H
			MOV     AH,09H 
			MOV		AL,'a'		;u�ϥ�
			MOV		BX,0070H
			MOV		CX,01
			INT		10H

			MOV		AH,02H		;�]�w��Ц�m
			MOV		BH,00
			MOV		DH,00		;�C
			MOV		DL,17		;��
			INT		10H
			MOV     AH,09H 
			MOV		AL,'s'		;p�ϥ�
			MOV		BX,0070H
			MOV		CX,01
			INT		10H

			MOV		AH,02H		;�]�w��Ц�m
			MOV		BH,00
			MOV		DH,00		;�C
			MOV		DL,18		;��
			INT		10H
			MOV     AH,09H 
			MOV		AL,'t'		;p�ϥ�
			MOV		BX,0070H
			MOV		CX,01
			INT		10H

			MOV		AH,02H		;�]�w��Ц�m
			MOV		BH,00
			MOV		DH,00		;�C
			MOV		DL,19		;��
			INT		10H
			MOV     AH,09H 
			MOV		AL,'e'		;p�ϥ�
			MOV		BX,0070H
			MOV		CX,01
			INT		10H
			RET
HighLight4	ENDP
;--------------------------------------------------------------------------------------------------------------------------------------------------------------
HighLight5	PROC	FAR
			MOV		AH,02H		;�]�w��Ц�m
			MOV		BH,00
			MOV		DH,00		;�C
			MOV		DL,15		;��
			INT		10H
			MOV     AH,09H		;C�ϥ�
			MOV		AL,'P'
			MOV		BX,0007H
			MOV		CX,01
			INT		10H

			MOV		AH,02H		;�]�w��Ц�m
			MOV		BH,00
			MOV		DH,00		;�C
			MOV		DL,16		;��
			INT		10H
			MOV     AH,09H 
			MOV		AL,'a'		;o�ϥ�
			MOV		BX,0007H
			MOV		CX,01
			INT		10H

			MOV		AH,02H		;�]�w��Ц�m
			MOV		BH,00
			MOV		DH,00		;�C
			MOV		DL,17		;��
			INT		10H
			MOV     AH,09H 
			MOV		AL,'s'		;p�ϥ�
			MOV		BX,0007H
			MOV		CX,01
			INT		10H

			MOV		AH,02H		;�]�w��Ц�m
			MOV		BH,00
			MOV		DH,00		;�C
			MOV		DL,18		;��
			INT		10H
			MOV     AH,09H 
			MOV		AL,'t'		;y�ϥ�
			MOV		BX,0007H
			MOV		CX,01
			INT		10H
			MOV		AH,02H		;�]�w��Ц�m
			MOV		BH,00
			MOV		DH,00		;�C
			MOV		DL,19		;��
			INT		10H
			MOV     AH,09H 
			MOV		AL,'e'		;y�ϥ�
			MOV		BX,0007H
			MOV		CX,01
			INT		10H
;---------
			MOV		AH,02H		;�]�w��Ц�m
			MOV		BH,00
			MOV		DH,00		;�C
			MOV		DL,08		;��
			INT		10H
			MOV     AH,09H		;C�ϥ�
			MOV		AL,'C'
			MOV		BX,0070H
			MOV		CX,01
			INT		10H

			MOV		AH,02H		;�]�w��Ц�m
			MOV		BH,00
			MOV		DH,00		;�C
			MOV		DL,09		;��
			INT		10H
			MOV     AH,09H 
			MOV		AL,'u'		;u�ϥ�
			MOV		BX,0070H
			MOV		CX,01
			INT		10H

			MOV		AH,02H		;�]�w��Ц�m
			MOV		BH,00
			MOV		DH,00		;�C
			MOV		DL,10		;��
			INT		10H
			MOV     AH,09H 
			MOV		AL,'t'		;p�ϥ�
			MOV		BX,0070H
			MOV		CX,01
			INT		10H
			RET
HighLight5	ENDP
;--------------------------------------------------------------------------------------------------------------------------------------------------------------
HighLight6	PROC	FAR
			MOV		AH,02H		;�]�w��Ц�m
			MOV		BH,00
			MOV		DH,00		;�C
			MOV		DL,08		;��
			INT		10H
			MOV     AH,09H		;C�ϥ�
			MOV		AL,'C'
			MOV		BX,0007H
			MOV		CX,01
			INT		10H

			MOV		AH,02H		;�]�w��Ц�m
			MOV		BH,00
			MOV		DH,00		;�C
			MOV		DL,09		;��
			INT		10H
			MOV     AH,09H 
			MOV		AL,'u'		;o�ϥ�
			MOV		BX,0007H
			MOV		CX,01
			INT		10H

			MOV		AH,02H		;�]�w��Ц�m
			MOV		BH,00
			MOV		DH,00		;�C
			MOV		DL,10		;��
			INT		10H
			MOV     AH,09H 
			MOV		AL,'t'		;p�ϥ�
			MOV		BX,0007H
			MOV		CX,01
			INT		10H
;---------
			MOV		AH,02H		;�]�w��Ц�m
			MOV		BH,00
			MOV		DH,00		;�C
			MOV		DL,00		;��
			INT		10H
			MOV     AH,09H		;C�ϥ�
			MOV		AL,'C'
			MOV		BX,0070H
			MOV		CX,01
			INT		10H

			MOV		AH,02H		;�]�w��Ц�m
			MOV		BH,00
			MOV		DH,00		;�C
			MOV		DL,01		;��
			INT		10H
			MOV     AH,09H 
			MOV		AL,'o'		;u�ϥ�
			MOV		BX,0070H
			MOV		CX,01
			INT		10H

			MOV		AH,02H		;�]�w��Ц�m
			MOV		BH,00
			MOV		DH,00		;�C
			MOV		DL,02		;��
			INT		10H
			MOV     AH,09H 
			MOV		AL,'p'		;p�ϥ�
			MOV		BX,0070H
			MOV		CX,01
			INT		10H

			MOV		AH,02H		;�]�w��Ц�m
			MOV		BH,00
			MOV		DH,00		;�C
			MOV		DL,03		;��
			INT		10H
			MOV     AH,09H 
			MOV		AL,'y'		;p�ϥ�
			MOV		BX,0070H
			MOV		CX,01
			INT		10H
			RET
HighLight6	ENDP
;--------------------------------------------------------------------------------------------------------------------------------------------------------------
ReHighLight	PROC	FAR
			MOV		AH,02H		;�]�w��Ц�m
			MOV		BH,00
			MOV		DH,00		;�C
			MOV		DL,00		;��
			INT		10H
			MOV     AH,09H		;C�ϥ�
			MOV		AL,' '
			MOV		BX,0007H
			MOV		CX,30
			INT		10H
			RET
ReHighLight	ENDP
;--------------------------------------------------------------------------------------------------------------------------------------------------------------
HighLight7	PROC	FAR
			MOV		AH,02H		;�]�w��Ц�m
			MOV		BH,00
			MOV		DH,24		;�C
			MOV		DL,43		;��
			INT		10H
			MOV     AH,09H		;C�ϥ�
			MOV		AL,'I'
			MOV		BX,0070H
			MOV		CX,01
			INT		10H

			MOV		AH,02H		;�]�w��Ц�m
			MOV		BH,00
			MOV		DH,24		;�C
			MOV		DL,44		;��
			INT		10H
			MOV     AH,09H 
			MOV		AL,'n'		;o�ϥ�
			MOV		BX,0070H
			MOV		CX,01
			INT		10H

			MOV		AH,02H		;�]�w��Ц�m
			MOV		BH,00
			MOV		DH,24		;�C
			MOV		DL,45		;��
			INT		10H
			MOV     AH,09H 
			MOV		AL,'s'		;p�ϥ�
			MOV		BX,0070H
			MOV		CX,01
			INT		10H

			MOV		AH,02H		;�]�w��Ц�m
			MOV		BH,00
			MOV		DH,24		;�C
			MOV		DL,46		;��
			INT		10H
			MOV     AH,09H		;C�ϥ�
			MOV		AL,'e'
			MOV		BX,0070H
			MOV		CX,01
			INT		10H

			MOV		AH,02H		;�]�w��Ц�m
			MOV		BH,00
			MOV		DH,24		;�C
			MOV		DL,47		;��
			INT		10H
			MOV     AH,09H 
			MOV		AL,'r'		;u�ϥ�
			MOV		BX,0070H
			MOV		CX,01
			INT		10H

			MOV		AH,02H		;�]�w��Ц�m
			MOV		BH,00
			MOV		DH,24		;�C
			MOV		DL,48		;��
			INT		10H
			MOV     AH,09H 
			MOV		AL,'t'		;p�ϥ�
			MOV		BX,0070H
			MOV		CX,01
			INT		10H
			RET
HighLight7	ENDP
;--------------------------------------------------------------------------------------------------------------------------------------------------------------
HighLight8	PROC	FAR
			MOV		AH,02H		;�]�w��Ц�m
			MOV		BH,00
			MOV		DH,24		;�C
			MOV		DL,53		;��
			INT		10H
			MOV     AH,09H		;C�ϥ�
			MOV		AL,'N'
			MOV		BX,0070H
			MOV		CX,01
			INT		10H

			MOV		AH,02H		;�]�w��Ц�m
			MOV		BH,00
			MOV		DH,24		;�C
			MOV		DL,54		;��
			INT		10H
			MOV     AH,09H 
			MOV		AL,'u'		;o�ϥ�
			MOV		BX,0070H
			MOV		CX,01
			INT		10H

			MOV		AH,02H		;�]�w��Ц�m
			MOV		BH,00
			MOV		DH,24		;�C
			MOV		DL,55		;��
			INT		10H
			MOV     AH,09H 
			MOV		AL,'m'		;p�ϥ�
			MOV		BX,0070H
			MOV		CX,01
			INT		10H

			MOV		AH,02H		;�]�w��Ц�m
			MOV		BH,00
			MOV		DH,24		;�C
			MOV		DL,56		;��
			INT		10H
			MOV     AH,09H		;C�ϥ�
			MOV		AL,'L'
			MOV		BX,0070H
			MOV		CX,01
			INT		10H

			MOV		AH,02H		;�]�w��Ц�m
			MOV		BH,00
			MOV		DH,24		;�C
			MOV		DL,57		;��
			INT		10H
			MOV     AH,09H 
			MOV		AL,'o'		;u�ϥ�
			MOV		BX,0070H
			MOV		CX,01
			INT		10H

			MOV		AH,02H		;�]�w��Ц�m
			MOV		BH,00
			MOV		DH,24		;�C
			MOV		DL,58		;��
			INT		10H
			MOV     AH,09H 
			MOV		AL,'c'		;p�ϥ�
			MOV		BX,0070H
			MOV		CX,01
			INT		10H

			MOV		AH,02H		;�]�w��Ц�m
			MOV		BH,00
			MOV		DH,24		;�C
			MOV		DL,59		;��
			INT		10H
			MOV     AH,09H 
			MOV		AL,'k'		;p�ϥ�
			MOV		BX,0070H
			MOV		CX,01
			INT		10H
;---------


			RET
HighLight8	ENDP
;--------------------------------------------------------------------------------------------------------------------------------------------------------------
reHighLight8	PROC	FAR
			MOV		AH,02H		;�]�w��Ц�m
			MOV		BH,00
			MOV		DH,24		;�C
			MOV		DL,53		;��
			INT		10H
			MOV     AH,09H		;C�ϥ�
			MOV		AL,' '
			MOV		BX,0007H
			MOV		CX,07
			INT		10H

			RET
reHighLight8	ENDP

;--------------------------------------------------------------------------------------------------------------------------------------------------------------
HighLight9	PROC	FAR
			MOV		AH,02H		;�]�w��Ц�m
			MOV		BH,00
			MOV		DH,24		;�C
			MOV		DL,64		;��
			INT		10H
			MOV     AH,09H		;C�ϥ�
			MOV		AL,'C'
			MOV		BX,0070H
			MOV		CX,01
			INT		10H

			MOV		AH,02H		;�]�w��Ц�m
			MOV		BH,00
			MOV		DH,24		;�C
			MOV		DL,65		;��
			INT		10H
			MOV     AH,09H 
			MOV		AL,'a'		;o�ϥ�
			MOV		BX,0070H
			MOV		CX,01
			INT		10H

			MOV		AH,02H		;�]�w��Ц�m
			MOV		BH,00
			MOV		DH,24		;�C
			MOV		DL,66		;��
			INT		10H
			MOV     AH,09H 
			MOV		AL,'p'		;p�ϥ�
			MOV		BX,0070H
			MOV		CX,01
			INT		10H

			MOV		AH,02H		;�]�w��Ц�m
			MOV		BH,00
			MOV		DH,24		;�C
			MOV		DL,67		;��
			INT		10H
			MOV     AH,09H		;C�ϥ�
			MOV		AL,'s'
			MOV		BX,0070H
			MOV		CX,01
			INT		10H

			RET
HighLight9	ENDP
;--------------------------------------------------------------------------------------------------------------------------------------------------------------
HighLight10	PROC	FAR
			MOV		AH,02H		;�]�w��Ц�m
			MOV		BH,00
			MOV		DH,[DI]		;�C
			MOV		DL,[SI]		;��
			INT		10H

			MOV     AH,09H		;C�ϥ�
			MOV		AL,' '
			MOV		BX,0007H
			MOV		CX,01
			INT		10H
			RET
HighLight10	ENDP

;--------------------------------------------------------------------------------------------------------------------------------------------------------------
;--------------------------------------------------------------------------------------------------------------------------------------------------------------
PrintDL		PROC	FAR	
			MOV		AH,02H			;�|�NDL�Ȧs�������e�L��ù��W
			MOV		DL,AL
			INT		21H
			RET
PrintDL		ENDP
;--------------------------------------------------------------------------------------------------------------------------------------------------------------
Printpart2	PROC	FAR	
			MOV		AH,02H		;�]�w��Ц�m
			MOV		BH,00
			MOV		DH,23		;�C
			MOV		DL,00		;��
			INT		10H
			LEA		DX,Msg1		;��ܰT��
			MOV		AH,09H		;��ܦb $ �Ÿ��H�e���r��
			INT		21H
			RET
Printpart2	ENDP
;--------------------------------------------------------------------------------------------------------------------------------------------------------------
Printpart1	PROC	FAR	
			MOV		AH,02H		;�]�w��Ц�m
			MOV		BH,00
			MOV		DH,01		;�C
			MOV		DL,00		;��
			INT		10H
			LEA		DX,Msg1		;��ܰT��
			MOV		AH,09H		;��ܦb $ �Ÿ��H�e���r��
			INT		21H
			RET
Printpart1	ENDP
;--------------------------------------------------------------------------------------------------------------------------------------------------------------
Show		PROC	FAR	
			MOV		AH,02H		;�]�w��Ц�m
			MOV		BH,00
			MOV		DH,00		;�C
			MOV		DL,00		;��
			INT		10H
			LEA		DX,Msg2		;��ܰT��
			MOV		AH,09H		;��ܦb $ �Ÿ��H�e���r��
			INT		21H
			RET
Show		ENDP
;--------------------------------------------------------------------------------------------------------------------------------------------------------------
Show1		PROC	FAR	
			MOV		AH,02H		;�]�w��Ц�m
			MOV		BH,00
			MOV		DH,24		;�C
			MOV		DL,43		;��
			INT		10H
			LEA		DX,Msg3		;��ܰT��
			MOV		AH,09H		;��ܦb $ �Ÿ��H�e���r��
			INT		21H
			RET
Show1		ENDP
;--------------------------------------------------------------------------------------------------------------------------------------------------------------
Show2		PROC	FAR	
			MOV		AH,02H		;�]�w��Ц�m
			MOV		BH,00
			MOV		DH,24		;�C
			MOV		DL,43		;��
			INT		10H
			MOV     AH,09H		;C�ϥ�
			MOV		AL,' '
			MOV		BX,0007H
			MOV		CX,6
			INT		10H

			MOV		AH,02H		;�]�w��Ц�m
			MOV		BH,00
			MOV		DH,24		;�C
			MOV		DL,43		;��
			INT		10H
			LEA		DX,Msg4		;��ܰT��
			MOV		AH,09H		;��ܦb $ �Ÿ��H�e���r��
			INT		21H
			RET
Show2		ENDP
;--------------------------------------------------------------------------------------------------------------------------------------------------------------
Show3		PROC	FAR	
			MOV		AH,02H		;�]�w��Ц�m
			MOV		BH,00
			MOV		DH,24		;�C
			MOV		DL,53		;��
			INT		10H
			LEA		DX,Msg5		;��ܰT��
			MOV		AH,09H		;��ܦb $ �Ÿ��H�e���r��
			INT		21H
			RET
Show3		ENDP
;--------------------------------------------------------------------------------------------------------------------------------------------------------------
Show4		PROC	FAR	
			MOV		AH,02H		;�]�w��Ц�m
			MOV		BH,00
			MOV		DH,24		;�C
			MOV		DL,63		;��
			INT		10H
			LEA		DX,Msg6		;��ܰT��
			MOV		AH,09H		;��ܦb $ �Ÿ��H�e���r��
			INT		21H
			RET
Show4		ENDP
;--------------------------------------------------------------------------------------------------------------------------------------------------------------
Start	PROC	FAR	
		ASSUME	SS:STACK,DS:DATASEG,CS:CODESEG,ES:CODESEG
        MOV		AX,DATASEG		
		MOV		DS,AX
		MOV		ES,AX
		RET
Start	ENDP
;--------------------------------------------------------------------------------------------------------------------------------------------------------------
Clean	PROC	FAR	
		MOV     AX,0600H        ;�ù��V�W����
        MOV     BH,07H			;�ݩʶ¥�
		MOV     CX,0000H		;���W��
        MOV     DX,184FH		;�k�U��
        INT     10H
		RET
Clean	ENDP
;--------------------------------------------------------------------------------------------------------------------------------------------------------------
Exit	PROC	FAR	
		MOV     AX,4C00H		;�����{��
		INT		21H
		RET
Exit	ENDP
;--------------------------------------------------------------------------------------------------------------------------------------------------------------
CODESEG ENDS
		END		Main