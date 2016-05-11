package com.os.jutils;

import net.sourceforge.pinyin4j.PinyinHelper;
import net.sourceforge.pinyin4j.format.HanyuPinyinCaseType;
import net.sourceforge.pinyin4j.format.HanyuPinyinOutputFormat;
import net.sourceforge.pinyin4j.format.HanyuPinyinToneType;
import net.sourceforge.pinyin4j.format.HanyuPinyinVCharType;
import net.sourceforge.pinyin4j.format.exception.BadHanyuPinyinOutputFormatCombination;

public class SpellHelper {
	private SpellHelper(){
		throw new Error("禁止实例化！");
	}
	/**
	 * 中文字符转化为拼音
	 * 
	 * @param ch
	 *            中文字符
	 * @return String
	 * @throws BadHanyuPinyinOutputFormatCombination
	 */
	public static String convertSpell(char ch) throws BadHanyuPinyinOutputFormatCombination {
		if (!isChinese(ch)) {
			throw new IllegalArgumentException("参数包含非中文");
		}
		HanyuPinyinOutputFormat pyFormat = new HanyuPinyinOutputFormat();
		pyFormat.setCaseType(HanyuPinyinCaseType.LOWERCASE);
		pyFormat.setToneType(HanyuPinyinToneType.WITHOUT_TONE);
		pyFormat.setVCharType(HanyuPinyinVCharType.WITH_V);

		String[] array = PinyinHelper.toHanyuPinyinStringArray(ch, pyFormat);
		return array[0].toString();
	}

	/**
	 * 中文字符串转化为拼音
	 * 
	 * @param str
	 *            中文字符串
	 * @return String
	 * @throws BadHanyuPinyinOutputFormatCombination
	 */
	public static String convertSpell(String str) throws BadHanyuPinyinOutputFormatCombination {
		if (!isChinese(str)) {
			throw new IllegalArgumentException("参数包含非中文");
		}
		StringBuilder spellStr = new StringBuilder();
		for (int i = 0; i < str.length(); i++) {
			spellStr.append(convertSpell(str.charAt(i)));
		}
		return spellStr.toString();
	}

	/**
	 * 判读字符是否是汉字
	 * 
	 * @param ch
	 *            校验字符
	 * @return boolean
	 */
	public static boolean isChinese(char ch) {
		// 汉字范围 \u4e00-\u9fa5 (中文)
		if (ch >= 19968 && ch <= 171941) {
			return true;
		} else {
			return false;
		}
	}

	/**
	 * 判断字符串是否全部是汉字
	 * 
	 * @param str
	 *            校验字符串
	 * @return boolean
	 */
	public static boolean isChinese(String str) {
		for (int i = 0; i < str.length(); i++) {
			char ch = str.charAt(i);
			if (!isChinese(ch)) {
				return false;
			}
		}
		return true;
	}

}
