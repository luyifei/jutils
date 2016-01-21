package com.os.jutils;

import org.junit.Assert;
import org.junit.Test;

import net.sourceforge.pinyin4j.format.exception.BadHanyuPinyinOutputFormatCombination;

public class SpellHelperTest {
	@Test
	public void convertSpellTest(){
		try {
			Assert.assertEquals("zhang", SpellHelper.convertSpell('张'));
			Assert.assertEquals("zhangsan", SpellHelper.convertSpell("张三"));
		} catch (BadHanyuPinyinOutputFormatCombination e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Test
	public void isChineseTest(){
		Assert.assertEquals(true, SpellHelper.isChinese('张'));
		Assert.assertEquals(true, SpellHelper.isChinese("哈哈我这是什么"));
	}
}
