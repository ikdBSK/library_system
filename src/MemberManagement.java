import java.util.Scanner;

public class MemberManagement {
		/**
		 * 会員情報
		 */
		public MemberManagement(MemberList ml){
			boolean memberContinue = true;
			//Scanner scanner = new Scanner(System.in);
			while(memberContinue){
				Scanner scanner = new Scanner(System.in);
				System.out.println("会員情報");
				System.out.println("何を行いますか。");
				System.out.println("1.新規会員登録");
				System.out.println("2.会員情報変更");
				System.out.println("3.退会手続き");
				System.out.println("4.会員確認(デバッグ用)");
				System.out.println("5.会員情報確認");
				System.out.println("6.延滞確認");
				System.out.println("7.戻る");
				int worknum = scanner.nextInt();
				switch(worknum){
					case 1:
						System.out.println("新規会員登録");
						memberRegister(ml);
						break;
					case 2:
						System.out.println("会員情報変更");
						memberEdit(ml);
						break;
					case 3:
						System.out.println("退会手続き");
						memberClose(ml);
						break;
					case 4:
						System.out.println("会員確認");
						for(int i=0;i<ml.member.size();i++){
							if(ml.member.get(i).exist == true) {
								System.out.println(ml.member.get(i).name[0]);
							}
						}
						break;
					case 5:
						System.out.println("会員情報確認");
						int memberCheck = idManagement(ml);
						break;
					case 6:
						System.out.println("延滞確認");
						DelayCheck(ml);
						break;
					case 7:
						memberContinue = false;
						break;
					default:
						System.out.println("入力した数値は正しくありません。");
						System.out.println("");
				}
			}
			//scanner.close();
		}


			/**
			 * 新規会員登録
			 */
			public void memberRegister(MemberList ml){
				Scanner scanner = new Scanner(System.in);
				int check = 2;
				String[] name = new String[2];
				String[] address = new String[3];
				while(check == 2){
					name = memberName();
					address = memberAddress();
					System.out.println("入力が正しければ1を、やり直す場合は2を入力してください。");
					System.out.println("名前:" + name[0] + name[1]);
					System.out.println("住所:" + address[0] + address[1] + address[2]);
					check = scanner.nextInt();
				}
				Member m = Member.createMember(name,address,null,false,null,ml.member.size());
				ml.member.add(m);
				System.out.println("会員登録が完了しました。");
				System.out.println("");
			}



				/**
				 * 会員情報変更
				 */
				public void memberEdit(MemberList ml){
					Scanner scanner = new Scanner(System.in);
					int id = -1;
					boolean workContinue = true;
					while(workContinue){
						id = idManagement(ml);
						if(id < 0) {
							workContinue = false;
						}else {
							Member m = ml.member.get(id);
							System.out.println("何を行いますか。");
							System.out.println("1.名前の変更");
							System.out.println("2.住所の変更");
							int worknum = scanner.nextInt();
							switch(worknum){
								case 1:
									int nameflag = 2;
									String[] name = new String[2];
									while(nameflag == 2){
										name = memberName();
										System.out.println("入力が正しければ1を、やり直す場合は2を入力してください。");
										System.out.println("名前:" + name[0] + name[1]);
										nameflag = scanner.nextInt();
									}
									m.name = name;
									System.out.println("名前の変更が完了しました。");
									System.out.println("");
									workContinue = false;
									break;
								case 2:
									int addressflag=2;
									String[] address = new String[3];
									while(addressflag == 2){
										address = memberAddress();
										System.out.println("入力が正しければ1を、やり直す場合は2を入力してください。");
										System.out.println("住所:" + address[0] + address[1] + address[2]);
										addressflag = scanner.nextInt();
									}
									m = Member.createMember(m.name,address,m.rentalBook,m.penalty,m.getPenaltyDate(),m.id);
									ml.member.set(id,m);
									System.out.println("住所の変更が完了しました。");
									System.out.println("");
									workContinue = false;
									break;
								default:
							}
						}
					}
				}

				/*
				 * 名前の入力に用いる
				 */
				public String[] memberName() {
					Scanner scanner = new Scanner(System.in);
					String[] name = new String[2];
					System.out.println("名字と名前を空白区切で入力してください。");
					name[0] = scanner.next();
					name[1] = scanner.next();
					return name;
				}

				/*
				 * 住所の入力に用いる
				 */
				public String[] memberAddress() {
					Scanner scanner = new Scanner(System.in);
					String[] address = new String[3];
					System.out.println("住所を以下にしたがって入力してください。");
					System.out.println("都道府県を入力してください。");
					address[0] = scanner.next();
					System.out.println("市町村区を入力してください。");
					address[1] = scanner.next();
					System.out.println("それ以降の住所を入力してください。");
					address[2] = scanner.next();
					return address;
				}

				/*
				 * 退会手続き
				 */
				public void memberClose(MemberList ml) {
					Scanner scanner = new Scanner(System.in);
					int id = idManagement(ml);
					boolean workContinue = true;
					if(id >= 0) {
						Member m = ml.member.get(id);
						if(m.rentalNumber != 0) {
							System.out.println("貸し出し中の書籍があるため退会できません。");
							System.out.println("");
							workContinue = false;
						}
						while(workContinue) {
							System.out.println("退会しますか?");
							System.out.println("1.はい");
							System.out.println("2.いいえ");
							switch(scanner.nextInt()) {
								case 1:
									m.exist=false;
									System.out.println("退会手続きが完了しました。");
									System.out.println("");
									workContinue = false;
									break;
								case 2:
									System.out.println("");
									workContinue = false;
									break;
								default:
									System.out.println("入力された値は正しい値ではありません。");
									System.out.println("");
							}
						}
					}
				}

				/*
				 * id管理
				 */
				public static int idManagement(MemberList ml) {
					Scanner scanner = new Scanner(System.in);
					System.out.println("会員IDを入力してください。");
					int id = scanner.nextInt();
					if(id < 0){
						System.out.println("入力された値は正しい値ではありません。");
						System.out.println("");
						return -1;
					}else if(ml.member.size()-1 < id || ml.member.get(id).exist == false){
						System.out.println("会員が存在しません。");
						System.out.println("");
						return -1;
					}else{
						Member m = ml.member.get(id);
						System.out.println("ID:" + m.id);
						System.out.println("名前:" + m.name[0] + m.name[1]);
						System.out.println("住所:" + m.address[0] + m.address[1] + m.address[2]);
						System.out.println("貸し出し中の本の数:" + m.rentalNumber);
						if(m.rentalNumber != 0) {
							for(int i=0;i<m.rentalNumber;i++) {
								System.out.println(i+1 + ".");
								System.out.println(m.rentalBook.get(i).name);
								System.out.println(m.rentalBook.get(i).cal.getTime());
							}
						}
						System.out.println("");
						return id;
					}
				}

				/*
				 * 延滞確認
				 */
				public static void DelayCheck(MemberList ml) {
					for(int i=0;i < ml.member.size();i++) {
						boolean dl = Deadline.deadlineCheck(ml.member.get(i));
					}
				}
}
