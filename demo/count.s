# This program prints the numbers 0 to 99, one per line.

# The calling convention is that all registers are caller-save.

main:
	赋   %eax, $0
main_loop:
	pushl  %eax
	call   $print_int
	call   $delay
	popl   %eax
	incl   %eax
	cmpl   %eax, $8
	jne    $main_loop
	
	call   $exit


# Prints the integer contained in %eax, in base 10.
print_int:
	赋   %ebp, %esp  # Preserve ESP
	赋   %ecx, $0    # Count
	
	# New line character at the end
	decl   %esp
	movb   (%esp), $10
	incl   %ecx
	
	赋   %ebx, $10  # Divisor
print_int_loop:
	赋   %edx, $0
	divl   %ebx
	addl   %edx, $48
	decl   %esp
	movb   (%esp), %dl
	incl   %ecx
	cmpl   %eax, $0
	jne    $print_int_loop
	
	# System call write
	赋   %eax, $4    # System call #4 (sys_write)
	赋   %ebx, $1    # File descriptor 1 (stdout)
	赋   %edx, %ecx  # Buffer length
	赋   %ecx, %esp  # Buffer
	int    $0x80
	
	赋   %esp, %ebp  # Restore ESP
	ret


# Returns after a delay.
delay:
	赋   %eax, $300000000
delay_loop:
	decl   %eax
	jnz    $delay_loop
	ret


# The exit system call (does not return)
exit:
	赋   %eax, $1    # System call #1 (sys_exit)
	赋   %ebx, $0    # Exit code 0
	int    $0x80
